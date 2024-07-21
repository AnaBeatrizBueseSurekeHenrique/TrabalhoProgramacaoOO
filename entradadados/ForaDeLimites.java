package entradadados;

/**
 * Esta exceção ocorre quando o usuário insere um valor que não pertence ao tabuleiro.
 * @author Ana Beatriz
 * @author Pedro
 * @version 1.0
 */
public class ForaDeLimites extends Exception {
    /**
     * Este contrutor inicializa a exceção com uma mensagem.
     * @param str A mensagem de erro causada pela exceção.
     */
    public ForaDeLimites(String str){
        super(str);
    }
}
