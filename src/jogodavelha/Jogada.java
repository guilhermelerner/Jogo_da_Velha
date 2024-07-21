package jogodavelha;

/**
 * Representa uma jogada em um jogo da velha, incluindo a posição e o jogador que realizou a jogada.
 * @author Guilherme Lerner e João Samuel Luy
 * @version 1.2
 */
public class Jogada {
    private int linha;
    private int coluna;
    private Jogador jogador;

    /**
     * Constrói uma nova jogada com a posição especificada e o jogador que a realizou.
     *
     * @param linha A linha onde a jogada foi realizada.
     * @param coluna A coluna onde a jogada foi realizada.
     * @param jogador O jogador que realizou a jogada.
     *
     * @exception IllegalArgumentException Se a linha ou a coluna estiver fora dos limites do tabuleiro.
     */
    public Jogada(int linha, int coluna, Jogador jogador) {
        if (linha < 0 || coluna < 0) {
            throw new IllegalArgumentException("Linha e coluna devem ser maiores ou iguais a zero.");
        }
        this.linha = linha;
        this.coluna = coluna;
        this.jogador = jogador;
    }

    /**
     * Retorna a linha onde a jogada foi realizada.
     * @return A linha da jogada.
     */
    public int getLinha() {
        return this.linha;
    }

    /**
     * Retorna a coluna onde a jogada foi realizada.
     * @return A coluna da jogada.
     */
    public int getColuna() {
        return this.coluna;
    }

    /**
     * Retorna o jogador que realizou a jogada.
     * @return O jogador que realizou a jogada.
     */
    public Jogador getJogador() {
        return this.jogador;
    }
}
