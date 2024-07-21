package armazenamento;
/**
 * @author Guilherme Lerner e João Samuel Luy
 * @version 1.2
 */
public interface GerenciaJogadores {

    void salvarJogador(String var1, int var2);

    int recuperarPontuacao(String var1);

    void exibirPontuacoes();
}
