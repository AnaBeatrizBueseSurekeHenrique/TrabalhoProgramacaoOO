package entradadados;
/**
 * Esta exceção ocorre quando o usuário insere um valor negativo.
 * @author Ana Beatriz
 * @author Pedro
 * @version 1.0
 */
public class ValorNegativo extends  Exception{
    /**
     * Este contrutor inicializa a exceção com uma mensagem.
     * @param str A mensagem de erro causada pela exceção.
     */
    public ValorNegativo(String str){
        super(str);
    }
}
