package entradadados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Esta classe realiza a entrada de dados pelo usuário.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */
public class Console {
    /**
     * Este método lê uma String.
     @return O valor da String inserida pelo usuário.
     */
    public static String readString(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e){
            throw new RuntimeException("Erro ao ler o dado!");
        }
    }
    /**
     Este método lê um Inteiro.
     @return O valor do Inteiro inserido pelo usuário.
     @param tamanho O valor maximo que pode ser inserido.
     */
    public int readInt(int tamanho) {
        String str;
        while (true) {
            try {
                str = readString();
                if (Integer.parseInt(str) < 0) {
                    throw new ValorNegativo("O valor não pode ser negativo! ");
                }
                if(Integer.parseInt(str) > tamanho || Integer.parseInt(str) == 0){
                    throw new ForaDeLimites("O valor não está incluido no tabuleiro! ");
                }
                return Integer.parseInt(str);
            }
            catch (RuntimeException e) {
                throw new RuntimeException("Entrada invalida!");
            } catch (ValorNegativo e) {
                System.out.println(e.getMessage() + "Tente Novamente!");
            }
            catch (ForaDeLimites e){
                System.out.println(e.getMessage() + "Tente novamente!");
            }

        }
    }

}
