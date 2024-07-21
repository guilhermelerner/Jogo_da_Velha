package jogodavelha;

public enum JogadorEnum {
    JOGADOR1('X'),
    JOGADOR2('O');

    private final char simbolo;

    JogadorEnum(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }
}
