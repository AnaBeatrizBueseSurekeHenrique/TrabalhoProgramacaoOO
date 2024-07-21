package jogodavelha;
import java.util.Objects;
import java.util.Random;
/**
 *Esta classe possui a lógica das jogadas do Bot.
 * Essa funcionalidade extra foi escolhida devido à necessidade de se jogar com apenas um jogador.
 * Este bot funciona escolhendo aleatóriamente uma das casas não ocupadas do tabuleiro.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */
public class Bot {
    /**
     * Este metodo possui a lógica da jogada do bot.
     * Ele funciona da seguinte forma: um par de números aleatórios será gerado.
     * Caso a casa do tabuleiro correspondente às coordenadas dos pares estiver vazia, será ali que o bot realizará sua jogada.
     * Se não, outro par será gerado, e isso ocorre nove vezes.
     * Quando é realizado o loop nove vezes, ou quando um par de coordenadas vazias é encontrado, o loop se encerra.
     * Caso o número de loops realizados for igual a 9, então outro loop acontecerá, onde se percorrerá toda a matriz até encontrar uma casa vazia.
     * Quando está casa é encontrada, o loop é encerrado, e esse par de coordenadas será a jogada realizada pelo bot.
     * @param jogo Recebe como parametro um objeto Jogo, em que as modificações da Jogada serão realizadas.
     */
    public void JogadaBot(Jogo jogo) {
        Random gerador = new Random();
        int i, j, k = 0;
        boolean gerarNovoNumero = true;
        i = gerador.nextInt(3);
        j = gerador.nextInt(3);
        while(k < 9 && gerarNovoNumero) {
            if (Objects.equals(jogo.getElementos()[i][j], " ")) {
                gerarNovoNumero = false;
            } else {
                i = gerador.nextInt(3);
                j = gerador.nextInt(3);
                k++;
            }
        }
        if(k == 9){
            for(int m = 0; m < 3; m++){
                for(int n = 0; n < 3; n++){
                    if(Objects.equals(jogo.getElementos()[m][n], " ")){
                        i = m;
                        j = n;
                        n = 3;
                        m = 3;
                    }
                }
            }
        }
        jogo.mudarElementos(i, j, 2);
        jogo.ImprimirTabuleiro();
    }
}
