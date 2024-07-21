package jogodavelha;

/**
 * Representa um jogador no jogo da velha, incluindo o nome e o símbolo associado ao jogador.
 *
 * @author Guilherme Lerner e João Samuel Luy
 * @version 1.2
 */
public class Jogador {
    private String nome;
    private JogadorEnum jogadorEnum;

    /**
     * Constrói um novo jogador com o nome e o símbolo especificados.
     * @param nome O nome do jogador.
     * @param jogadorEnum O enum que representa o símbolo do jogador.
     * @exception IllegalArgumentException Se o nome for nulo ou vazio.
     */
    public Jogador(String nome, JogadorEnum jogadorEnum) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do jogador não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        this.jogadorEnum = jogadorEnum;
    }

    /**
     * Retorna o nome do jogador.
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o símbolo associado ao jogador.
     * @return O símbolo do jogador, representado por um caractere.
     */
    public char getSimbolo() {
        return jogadorEnum.getSimbolo();
    }
}
