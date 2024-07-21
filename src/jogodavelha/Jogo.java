package jogodavelha;

import armazenamento.GerenciaJogadores;
import excecoes.NomeJogadorInvalidoException;
import excecoes.NomeJogadorRepetidoException;
import entradadados.Console;

public class Jogo {
    private Tabuleiro tabuleiro;
    private GerenciaJogadores gerenciaJogadores;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public Jogo(Tabuleiro tabuleiro, GerenciaJogadores gerenciaJogadores) {
        this.tabuleiro = tabuleiro;
        this.gerenciaJogadores = gerenciaJogadores;
    }

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

    private void validarNomeJogador(String nome) throws NomeJogadorInvalidoException {
        if (nome.matches(".*\\d.*")) {
            throw new NomeJogadorInvalidoException("O nome do jogador não pode conter números.");
        }
    }

    private void verificarNomeRepetido(String nome1, String nome2) throws NomeJogadorRepetidoException {
        if (nome1.equals(nome2)) {
            throw new NomeJogadorRepetidoException("Os nomes dos jogadores não podem ser iguais.");
        }
    }

    private void atualizarPontuacoes(Jogador vencedor) {
        int pontuacaoAtual = gerenciaJogadores.recuperarPontuacao(vencedor.getNome());
        gerenciaJogadores.salvarJogador(vencedor.getNome(), pontuacaoAtual + 1);
    }
}
