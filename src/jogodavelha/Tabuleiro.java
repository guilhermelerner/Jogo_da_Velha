package jogodavelha;

public abstract class Tabuleiro {
    protected char[][] tabuleiro;
    protected int tamanho;

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.tabuleiro = new char[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                this.tabuleiro[i][j] = ' ';
            }
        }
    }

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

    public boolean realizarJogada(Jogada jogada) {
        if (this.tabuleiro[jogada.getLinha()][jogada.getColuna()] == ' ') {
            this.tabuleiro[jogada.getLinha()][jogada.getColuna()] = jogada.getJogador().getSimbolo();
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarVencedor(Jogador jogador) {
        char simbolo = jogador.getSimbolo();
        for (int i = 0; i < this.tamanho; i++) {
            if (this.verificarLinha(i, simbolo) || this.verificarColuna(i, simbolo)) {
                return true;
            }
        }
        return this.verificarDiagonais(simbolo);
    }

    private boolean verificarLinha(int linha, char simbolo) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.tabuleiro[linha][i] != simbolo) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarColuna(int coluna, char simbolo) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.tabuleiro[i][coluna] != simbolo) {
                return false;
            }
        }
        return true;
    }

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

    public int getTamanho() {
        return tamanho;
    }
}
