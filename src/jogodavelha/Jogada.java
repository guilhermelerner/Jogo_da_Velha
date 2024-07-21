package jogodavelha;

public class Jogada {
    private int linha;
    private int coluna;
    private Jogador jogador;

    public Jogada(int linha, int coluna, Jogador jogador) {
        this.linha = linha;
        this.coluna = coluna;
        this.jogador = jogador;
    }

    public int getLinha() {
        return this.linha;
    }

    public int getColuna() {
        return this.coluna;
    }

    public Jogador getJogador() {
        return this.jogador;
    }
}