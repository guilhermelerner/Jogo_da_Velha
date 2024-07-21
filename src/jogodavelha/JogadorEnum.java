package jogodavelha;

/**
 * Enumeração que representa os dois jogadores no jogo da velha e seus respectivos símbolos.
 *
 * @author Guilherme Lerner e João Samuel Luy
 * @version 1.2
 */
public enum JogadorEnum {
    JOGADOR1('X'),
    JOGADOR2('O');

    private final char simbolo;

    /**
     * Constrói uma nova enumeração de jogador com o símbolo especificado.
     * @param simbolo O símbolo associado ao jogador, representado por um caractere.
     */
    JogadorEnum(char simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Retorna o símbolo associado ao jogador.
     *
     * @return O símbolo do jogador, representado por um caractere.
     */
    public char getSimbolo() {
        return simbolo;
    }
}
