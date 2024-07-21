package jogodavelha;


import java.io.Serializable;
/**
 Esta classe possui as informações do jogador.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */

public class Jogador implements Serializable {
    /**
     * Nome do Jogador.
     */
    private String nome;
    /**
     * Marca do jogador, ou seja, 'x' ou 'o'.
     */
    private char marca;
    /**
     * Pontuação do jogador.
     */
    private int pontuacao;
    /**
     Este construtor incializa os atributos nome, marca e pontuação.
     @param marca O caractere utilizado pelo jogador, podendo ser 'x' ou 'o'.
     @param nome O nome atribuido ao jogador.
     */
    public Jogador(String nome, char marca) {
        this.nome = nome;
        this.marca = marca;
        this.pontuacao = 0;
    }
    /**
     Esse método obtém o valor do atributo nome.
     @return O valor do atributo nome como uma String.
     */
    public String getNome() {
        return nome;
    }
    /**
     Esse método obtém o valor do atributo marca.
     @return O valor do atributo marca como um Char.
     */
    public char getMarca() {
        return marca;
    }
    /**
     Esse método obtém o valor do atributo pontuacao.
     @return O valor do atributo pontuacao como um Int.
     */
    public int getPontuacao() {
        return pontuacao;
    }
    /**
     Esse método incrementa em 1 o valor do atributo pontuacao.
     */
    public void incrementarPontuacao() {
        this.pontuacao++;
    }
    /**
     Esse método transforma os valores dos atributos da classe em uma String.
     @return Retorna o valor dos atributos como uma String.
     */
    @Override
    public String toString(){
        return " " + nome + " Marca: " + marca + " Pontos: " + pontuacao + '\n' + '\n';
    }
}
