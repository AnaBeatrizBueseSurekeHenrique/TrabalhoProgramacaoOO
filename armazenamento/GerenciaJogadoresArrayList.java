package armazenamento;

import jogodavelha.Jogador;
import java.util.ArrayList;
import java.util.List;
/**
 Esta classe armazena as informações dos jogadores em um array.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores {
    /**
     * Lista usada para armazenar os dados dos jogadores.
     */
    static private List<Jogador> jogadores = new ArrayList<>();

    /**
     * Este metodo é reponsável pelo armazenamento das informações dos jogadores.
     * @param jogador Recebe como parametro um objeto jogador, cujas informações serão armazenadas.
     */
    public static void salvarJogador(Jogador jogador) {

        jogadores.add(jogador);
    }

    /**
     * Está classe é responsável por mostrar os valores armazenados no ArrayList, transformados em String.
     */
    public static void mostrarValores(){

        System.out.println(jogadores.toString());
    }



}
