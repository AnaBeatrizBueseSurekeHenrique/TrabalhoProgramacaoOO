package jogodavelha;

import entradadados.Console;
/**
 Esta classe possui a lógica da jogada de cada Jogador.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */
public class Jogada {
    /**
     * Recebe valor inserido pelo jogador.
     */
    Console entrada = new Console();
    /**
     Este metodo irá realizar o turno do jogador, checando se sua jogada é valida ou não, e a realizando.
     @param jogo Recebe um objeto jogo, usada para definir a logica do jogo.
     @param k  Numero do jogador, sendo ele 1 ou 2.
     */
    public void Jogar(Jogo jogo, int k){
        int i, j;
        boolean a = false;
        while(a == false){
            try {
                System.out.println("Jogador: " + k);
                System.out.println("Insira a linha");
                i = entrada.readInt(3);
                System.out.println("Insira a coluna");
                j = entrada.readInt(3);
                if (jogo.getElementos()[i - 1][j - 1] == " ") {
                    jogo.mudarElementos(i - 1, j - 1, k);
                    jogo.ImprimirTabuleiro();
                    a = true;
                } else {
                    System.out.println("Posição já ocupada! Escolha outra");
                }
            }
             catch(RuntimeException e){
                System.out.println("Valor invalido! Insira um número");
            }
        }
    }
}