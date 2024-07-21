package jogodavelha;

import java.io.File;
/**
 Esta é a classe principal, onde o jogo é executado.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */
public class ClassePrincipal {
    /**
     * Este metodo realiza a execução do jogo
     * @param args Não utilizado.
     */
    public static void main(String[] args) {
        /**
         * Recebe um objeto jogo, que será executado e iniciará a partida.
         */
        Jogo jogo = new Jogo();
        File log = new File("log.txt");
        if(log.exists()) {
            log.delete();
        }
        int a = 0;
        System.out.println("                       # JOGO DA VELHA #");
        System.out.println("Escolha o modo de jogo: ");
        System.out.println("1 - Modo Player versus Player");
        System.out.println("2 - Modo Player versus Computador");
        System.out.println("3 - Sair do game");
        a = jogo.escolhaModo(a);
        switch (a){
            case 1:
                jogo.rodando(jogo);
                break;
            case 2:
                jogo.jogarComBot(jogo);
                break;
            case 3:
                break;
        }
    }
}
