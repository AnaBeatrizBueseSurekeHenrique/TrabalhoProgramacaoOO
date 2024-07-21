package jogodavelha;
/**
 Esta classe armazena o tabuleiro do jogo da velha.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */
public class Tabuleiro {
    /**
     * Esta matriz armazena os valores do tabuleiro.
     */
    private String elementos[][] = new String[3][3];

    /**
     * Este construtor inicializa a matriz.
     */
    public  Tabuleiro(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                elementos[i][j] = " ";
            }
        }
    }

    /**
     * Este método altera os elementos da matriz baseados no jogador.
     * Caso for jogador 1, o elemento será "x", caso for jogador 2, o elemento será "o".
     * @param i Abscissa da matriz.
     * @param j Ordenada da matriz.
     * @param player Número do jogador cuja marca será inserida na matriz.
     */
    public void mudarElementos(int i, int j, int player) {
        switch (player){
            case 1:
                elementos[i][j] = "x";
                break;
            case 2:
                elementos[i][j] = "o";
                break;
        }
    }

    /**
     * Imprime a matriz.
     */
    public void ImprimirTabuleiro(){

        for(int i = 0; i < 3; i++){
            String.format(" ", 100);
            for(int j = 0; j < 3; j++){
                System.out.print(" " + elementos[i][j] + " ");
                if(j < 2 ) {

                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < 2) {
                System.out.println("---|---|---");
            }
        }
    }

    /**
     * Mostra os valores da matriz.
     * @return O valor de uma coordenada especifica da matriz como String.
     */
    public String[][] getElementos() {
        return elementos;
    }

    /**
     * Método responsável por tirar todas marcas dos jogadores, deixando o tabuleiro limpo.
     */
    public void LimparTabuleiro(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                elementos[i][j] = " ";
            }
        }
    }
}
