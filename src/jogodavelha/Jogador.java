package jogodavelha;

public class Jogador {
    private String nome;
    private JogadorEnum jogadorEnum;

    public Jogador(String nome, JogadorEnum jogadorEnum) {
        this.nome = nome;
        this.jogadorEnum = jogadorEnum;
    }

    public String getNome() {
        return nome;
    }

    public char getSimbolo() {
        return jogadorEnum.getSimbolo();
    }
}
