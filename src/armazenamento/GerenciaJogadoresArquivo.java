package armazenamento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GerenciaJogadoresArquivo implements GerenciaJogadores {
    // Nome do arquivo que armazena os dados dos jogadores
    private static final String ARQUIVO_JOGADORES = "jogadores.txt";

    // Mapa para armazenar os jogadores e suas pontuações
    private Map<String, Integer> jogadores = new HashMap<>();

    // Construtor que carrega os dados dos jogadores do arquivo ao iniciar
    public GerenciaJogadoresArquivo() {
        this.carregarJogadores();
    }

    // Método para salvar ou atualizar a pontuação de um jogador
    public void salvarJogador(String nome, int pontuacao) {
        this.jogadores.put(nome, pontuacao);
        this.salvarJogadores();
    }

    // Método para recuperar a pontuação de um jogador pelo nome
    public int recuperarPontuacao(String nome) {
        return this.jogadores.getOrDefault(nome, 0);
    }

    // Método para exibir todas as pontuações dos jogadores
    public void exibirPontuacoes() {
        System.out.println("\n--- Pontuações ---");
        Iterator<Map.Entry<String, Integer>> iterator = this.jogadores.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            PrintStream output = System.out;
            String jogadorNome = entry.getKey();
            output.println("Jogador: " + jogadorNome + " - Pontuação: " + entry.getValue());
        }
    }

    // Método para carregar os dados dos jogadores do arquivo
    private void carregarJogadores() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_JOGADORES));

            String linha;
            try {
                while ((linha = reader.readLine()) != null) {
                    String[] dados = linha.split(",");
                    this.jogadores.put(dados[0], Integer.parseInt(dados[1]));
                }
            } catch (Throwable readError) {
                try {
                    reader.close();
                } catch (Throwable closeError) {
                    readError.addSuppressed(closeError);
                }
                throw readError;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para salvar os dados dos jogadores no arquivo
    private void salvarJogadores() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_JOGADORES));

            try {
                Iterator<Map.Entry<String, Integer>> iterator = this.jogadores.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    String jogadorNome = entry.getKey();
                    writer.write(jogadorNome + "," + entry.getValue());
                    writer.newLine();
                }
            } catch (Throwable writeError) {
                try {
                    writer.close();
                } catch (Throwable closeError) {
                    writeError.addSuppressed(closeError);
                }
                throw writeError;
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
