package jogodavelha;

import armazenamento.GerenciaJogadores;
import armazenamento.GerenciaJogadoresArrayList;
import java.util.Scanner;

public class ClassePrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        GerenciaJogadores gerenciaJogadores = new GerenciaJogadoresArrayList();

        while (!sair) {
            System.out.println("\n--- Jogo da Velha ---");
            System.out.println("1. Iniciar Jogo 3x3");
            System.out.println("2. Iniciar Jogo 5x5");
            System.out.println("3. Acessar Pontuações");
            System.out.println("4. Sobre o Jogo");
            System.out.print("Escolha sua opção: ");
            int opcao = scanner.nextInt();

            Tabuleiro tabuleiro;
            switch (opcao) {
                case 1:
                    tabuleiro = new Tabuleiro3x3();
                    iniciarJogo(tabuleiro, gerenciaJogadores);
                    break;
                case 2:
                    tabuleiro = new Tabuleiro5x5();
                    iniciarJogo(tabuleiro, gerenciaJogadores);
                    break;
                case 3:
                    gerenciaJogadores.exibirPontuacoes();
                    break;
                case 4:
                    System.out.println("Este é um jogo feito pelos alunos Guilherme Lerner e Joao Luy. Espero que gostem!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void iniciarJogo(Tabuleiro tabuleiro, GerenciaJogadores gerenciaJogadores) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do Jogador 1: ");
        String nomeJogador1 = scanner.nextLine();
        System.out.print("Digite o nome do Jogador 2: ");
        String nomeJogador2 = scanner.nextLine();

        Jogo jogo = new Jogo(tabuleiro, gerenciaJogadores);
        jogo.iniciar(nomeJogador1, nomeJogador2);
    }
}
