
package armazenamento;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Guilherme Lerner e João Samuel Luy
 * @version 1.2
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores {
    // Lista para armazenar os jogadores e suas pontuações
    private List<JogadorPontuacao> jogadores = new ArrayList<>();

    // Construtor padrão
    public GerenciaJogadoresArrayList() {
    }

    /**
     * Salva ou atualiza a pontuação de um jogador.
     *
     * @param nome O nome do jogador. Não deve ser nulo.
     * @param pontuacao A pontuação do jogador. Deve ser um valor não negativo.
     */

    // Método para salvar ou atualizar a pontuação de um jogador
    public void salvarJogador(String nome, int pontuacao) {
        Iterator<JogadorPontuacao> iterator = this.jogadores.iterator();

        JogadorPontuacao jogador;
        // Itera sobre a lista para verificar se o jogador já existe
        do {
            if (!iterator.hasNext()) {
                // Se o jogador não existir, adiciona um novo jogador à lista
                this.jogadores.add(new JogadorPontuacao(nome, pontuacao));
                return;
            }
            jogador = iterator.next();
        } while (!jogador.getNome().equals(nome));

        // Se o jogador já existir, atualiza a pontuação
        jogador.setPontuacao(pontuacao);
    }

    /**
     * Recupera a pontuação de um jogador pelo nome.
     *
     * @param nome O nome do jogador. Não deve ser nulo.
     * @return A pontuação do jogador. Se o jogador não for encontrado, retorna 0.
     */

    // Método para recuperar a pontuação de um jogador pelo nome
    public int recuperarPontuacao(String nome) {
        Iterator<JogadorPontuacao> iterator = this.jogadores.iterator();

        JogadorPontuacao jogador;
        // Itera sobre a lista para encontrar o jogador pelo nome
        do {
            if (!iterator.hasNext()) {
                // Se o jogador não for encontrado, retorna 0
                return 0;
            }
            jogador = iterator.next();
        } while (!jogador.getNome().equals(nome));

        // Retorna a pontuação do jogador encontrado
        return jogador.getPontuacao();
    }

    // Método para exibir todas as pontuações dos jogadores
    public void exibirPontuacoes() {
        System.out.println("\n--- Pontuações ---");
        Iterator<JogadorPontuacao> iterator = this.jogadores.iterator();

        // Itera sobre a lista para exibir cada jogador e sua pontuação
        while (iterator.hasNext()) {
            JogadorPontuacao jogador = iterator.next();
            PrintStream output = System.out;
            String jogadorNome = jogador.getNome();
            output.println("Jogador: " + jogadorNome + " - Pontuação: " + jogador.getPontuacao());
        }
    }

    // Classe interna para representar um jogador e sua pontuação
    private static class JogadorPontuacao {
        private String nome;
        private int pontuacao;

        // Construtor para inicializar o nome e a pontuação do jogador
        public JogadorPontuacao(String nome, int pontuacao) {
            this.nome = nome;
            this.pontuacao = pontuacao;
        }

        /**
         * Getter para o nome do jogador.
         *
         * @return O nome do jogador.
         */

        // Getter para o nome do jogador
        public String getNome() {
            return this.nome;
        }

        /**
         * Getter para a pontuação do jogador.
         *
         * @return A pontuação do jogador.
         */

        // Getter para a pontuação do jogador
        public int getPontuacao() {
            return this.pontuacao;
        }

        /**
         * Setter para atualizar a pontuação do jogador.
         *
         * @param pontuacao A nova pontuação do jogador. Deve ser um valor não negativo.
         */

        // Setter para atualizar a pontuação do jogador
        public void setPontuacao(int pontuacao) {
            this.pontuacao = pontuacao;
        }
    }
}
