package entradadados;

import excecoes.NomeJogadorInvalidoException;
import excecoes.NomeJogadorRepetidoException;
import jogodavelha.Jogada;
import jogodavelha.Jogador;
import java.util.Scanner;

/**
 * @author Guilherme Lerner e João Samuel Luy
 * @version 1.2
 */
public class Console {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @param jogador O jogador que está fazendo a jogada.
     * @param tamanhoTabuleiro O tamanho do tabuleiro, usado para validar a entrada do jogador.
     * @return Um objeto {@link Jogada} que representa a linha, coluna e o jogador que fez a jogada.
     * @exception IllegalArgumentException Se a entrada do jogador estiver fora dos limites do tabuleiro.
     */
    public static Jogada lerJogada(Jogador jogador, int tamanhoTabuleiro) {
        int linha, coluna;
        while (true) {
            System.out.println("Jogador " + jogador.getSimbolo() + " (" + jogador.getNome() + "), insira sua jogada (linha e coluna de 0 a " + (tamanhoTabuleiro - 1) + "): ");
            linha = scanner.nextInt();
            coluna = scanner.nextInt();
            if (linha >= 0 && linha < tamanhoTabuleiro && coluna >= 0 && coluna < tamanhoTabuleiro) {
                break;
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }
        return new Jogada(linha, coluna, jogador);
    }
}
