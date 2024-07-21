package jogodavelha;

/**
 * Classe abstrata que representa um tabuleiro de jogo da velha.
 * Define a estrutura e as operações básicas que podem ser realizadas no tabuleiro.
 *
 * @author Guilherme Lerner e João Samuel Luy
 * @version 1.2
 */
public abstract class Tabuleiro {
    protected char[][] tabuleiro;
    protected int tamanho;

    /**
     * Constrói um novo tabuleiro com o tamanho especificado.
     *
     * @param tamanho O tamanho do tabuleiro (número de linhas e colunas).
     */
    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.tabuleiro = new char[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                this.tabuleiro[i][j] = ' ';
            }
        }
    }

    /**
     * Imprime o tabuleiro no console.
     *
     * @return void
     */
    public void imprimirTabuleiro() {
        System.out.print("  ");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < this.tamanho; j++) {
                System.out.print(this.tabuleiro[i][j]);
                if (j < this.tamanho - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < this.tamanho - 1) {
                System.out.print("  ");
                for (int k = 0; k < this.tamanho - 1; k++) {
                    System.out.print("--");
                }
                System.out.println("-");
            }
        }
    }

    /**
     * Realiza uma jogada no tabuleiro.
     *
     * @param jogada A jogada a ser realizada, incluindo a posição e o jogador.
     * @return true se a jogada foi realizada com sucesso, false se a célula já estiver ocupada.
     */
    public boolean realizarJogada(Jogada jogada) {
        if (this.tabuleiro[jogada.getLinha()][jogada.getColuna()] == ' ') {
            this.tabuleiro[jogada.getLinha()][jogada.getColuna()] = jogada.getJogador().getSimbolo();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se o jogador especificado é o vencedor.
     *
     * @param jogador O jogador a ser verificado.
     * @return true se o jogador é o vencedor, false caso contrário.
     */
    public boolean verificarVencedor(Jogador jogador) {
        char simbolo = jogador.getSimbolo();
        for (int i = 0; i < this.tamanho; i++) {
            if (this.verificarLinha(i, simbolo) || this.verificarColuna(i, simbolo)) {
                return true;
            }
        }
        return this.verificarDiagonais(simbolo);
    }

    /**
     * Verifica se há uma linha completa com o símbolo do jogador.
     *
     * @param linha A linha a ser verificada.
     * @param simbolo O símbolo do jogador.
     * @return true se a linha estiver completa com o símbolo do jogador, false caso contrário.
     */
    private boolean verificarLinha(int linha, char simbolo) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.tabuleiro[linha][i] != simbolo) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se há uma coluna completa com o símbolo do jogador.
     *
     * @param coluna A coluna a ser verificada.
     * @param simbolo O símbolo do jogador.
     * @return true se a coluna estiver completa com o símbolo do jogador, false caso contrário.
     */
    private boolean verificarColuna(int coluna, char simbolo) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.tabuleiro[i][coluna] != simbolo) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se há uma diagonal completa com o símbolo do jogador.
     *
     * @param simbolo O símbolo do jogador.
     * @return true se uma das diagonais estiver completa com o símbolo do jogador, false caso contrário.
     */
    private boolean verificarDiagonais(char simbolo) {
        boolean diagonalPrincipal = true;
        boolean diagonalSecundaria = true;
        for (int i = 0; i < this.tamanho; i++) {
            if (this.tabuleiro[i][i] != simbolo) {
                diagonalPrincipal = false;
            }
            if (this.tabuleiro[i][this.tamanho - i - 1] != simbolo) {
                diagonalSecundaria = false;
            }
        }
        return diagonalPrincipal || diagonalSecundaria;
    }

    /**
     * Verifica se o tabuleiro está cheio, sem espaços vazios.
     *
     * @return true se o tabuleiro estiver cheio, false caso contrário.
     */
    public boolean tabuleiroCheio() {
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                if (this.tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Retorna o tamanho do tabuleiro.
     *
     * @return O tamanho do tabuleiro.
     */
    public int getTamanho() {
        return tamanho;
    }
}
