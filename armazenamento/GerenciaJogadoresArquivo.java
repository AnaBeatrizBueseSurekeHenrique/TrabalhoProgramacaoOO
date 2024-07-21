package armazenamento;

import jogodavelha.Jogador;

import java.io.*;
import java.io.File;
import java.io.IOException;
/**
 Esta classe armazena as informações dos jogadores um arquivo txt.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */

public class GerenciaJogadoresArquivo implements GerenciaJogadores{
    /**
     * Este metodo é responsavel por salvar os dados dos jogadores em uma String.
     * @param jogador Recebe um atributo Jogador, cujas informações serão armazenadas em um arquivo.
     */
    public static void salvarJogador(Jogador jogador) {
        File log = new File("log.txt");
        try {
            if (!log.exists()) {
                log.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(log, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(jogador.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("erro!");
        }
    }

}
