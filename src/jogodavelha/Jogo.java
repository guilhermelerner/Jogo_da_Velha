package jogodavelha;

import armazenamento.GerenciaJogadores;
import excecoes.NomeJogadorInvalidoException;
import excecoes.NomeJogadorRepetidoException;
import entradadados.Console;

/**
 * Gerencia a lógica do jogo da velha, incluindo a inicialização do jogo, execução das jogadas,
 * e verificação de vencedores e empates.
 *
 * @author Guilherme Lerner e João Samuel Luy
 * @version 1.2
 */
public class Jogo {
    private Tabuleiro tabuleiro;
    private GerenciaJogadores gerenciaJogadores;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    /**
     * Constrói uma nova instância do jogo com o tabuleiro e o gerenciamento de jogadores fornecidos.
     *
     * @param tabuleiro O tabuleiro do jogo onde as jogadas serão realizadas.
     * @param gerenciaJogadores A instância responsável pelo gerenciamento das pontuações dos jogadores.
     */
    public Jogo(Tabuleiro tabuleiro, GerenciaJogadores gerenciaJogadores) {
        this.tabuleiro = tabuleiro;
        this.gerenciaJogadores = gerenciaJogadores;
    }

    /**
     * Inicia o jogo com os nomes dos dois jogadores fornecidos.
     *
     * @param nomeJogador1 O nome do primeiro jogador.
     * @param nomeJogador2 O nome do segundo jogador.
     *
     * @exception NomeJogadorInvalidoException Se algum dos nomes dos jogadores contiver números.
     * @exception NomeJogadorRepetidoException Se os nomes dos jogadores forem iguais.
     */
    public void iniciar(String nomeJogador1, String nomeJogador2) {
        try {
            validarNomeJogador(nomeJogador1);
            validarNomeJogador(nomeJogador2);
            verificarNomeRepetido(nomeJogador1, nomeJogador2);

            jogador1 = new Jogador(nomeJogador1, JogadorEnum.JOGADOR1);
            jogador2 = new Jogador(nomeJogador2, JogadorEnum.JOGADOR2);
            jogadorAtual = jogador1;

            while (true) {
                tabuleiro.imprimirTabuleiro();
                Jogada jogada = Console.lerJogada(jogadorAtual, tabuleiro.getTamanho());

                if (tabuleiro.realizarJogada(jogada)) {
                    if (tabuleiro.verificarVencedor(jogadorAtual)) {
                        tabuleiro.imprimirTabuleiro();
                        System.out.println("Parabéns " + jogadorAtual.getNome() + ", você venceu!");
                        atualizarPontuacoes(jogadorAtual);
                        break;
                    } else if (tabuleiro.tabuleiroCheio()) {
                        tabuleiro.imprimirTabuleiro();
                        System.out.println("Empate!");
                        break;
                    }

                    jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
                } else {
                    System.out.println("A célula já está ocupada. Tente novamente.");
                }
            }
        } catch (NomeJogadorInvalidoException | NomeJogadorRepetidoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Valida se o nome do jogador contém números.
     *
     * @param nome O nome do jogador a ser validado.
     *
     * @exception NomeJogadorInvalidoException Se o nome do jogador contiver números.
     */
    private void validarNomeJogador(String nome) throws NomeJogadorInvalidoException {
        if (nome.matches(".*\\d.*")) {
            throw new NomeJogadorInvalidoException("O nome do jogador não pode conter números.");
        }
    }

    /**
     * Verifica se os nomes dos dois jogadores são iguais.
     *
     * @param nome1 O nome do primeiro jogador.
     * @param nome2 O nome do segundo jogador.
     *
     * @exception NomeJogadorRepetidoException Se os nomes dos jogadores forem iguais.
     */
    private void verificarNomeRepetido(String nome1, String nome2) throws NomeJogadorRepetidoException {
        if (nome1.equals(nome2)) {
            throw new NomeJogadorRepetidoException("Os nomes dos jogadores não podem ser iguais.");
        }
    }

    /**
     * Atualiza a pontuação do jogador vencedor no gerenciamento de jogadores.
     *
     * @param vencedor O jogador que venceu o jogo.
     */
    private void atualizarPontuacoes(Jogador vencedor) {
        int pontuacaoAtual = gerenciaJogadores.recuperarPontuacao(vencedor.getNome());
        gerenciaJogadores.salvarJogador(vencedor.getNome(), pontuacaoAtual + 1);
    }
}
