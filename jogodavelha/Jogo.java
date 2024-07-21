package jogodavelha;

import armazenamento.GerenciaJogadoresArquivo;
import armazenamento.GerenciaJogadoresArrayList;

import java.util.ArrayList;
import java.util.List;
/**
 Esta classe possui a lógica do jogo.
 @author Ana Beatriz
 @author Pedro
 @version 1.0
 */
public class Jogo extends Tabuleiro {
    /**
     * As informações dos jogadores em uma lista.
     */
    protected List<Jogador> jogadores;
    /**
     * Um objeto da classe jogada, possibilitando as jogadas realizadas pelos jogadores.
     */
    Jogada jogada = new Jogada();
    /**
     Este construtor incializa os atributos da superclasse, além de adicionar mais dois novos jogadores.
     */
    public Jogo(){
        super();
        jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Jogador 1", 'X'));
        jogadores.add(new Jogador("Jogador 2", 'O'));

    }

    /**
     * Esse método determina o inteiro a ser retornado na classe App para a escolha do modo de jogo no menu.
     * @param a O valor inserido pelo usuario.
     * @return 1 caso seja modo de jogo PvP, 2 caso seja PvE ou 3 caso queira sair do jogo.
     */
    public int escolhaModo(int a){
        boolean HouveExceção = false;
        while(!HouveExceção) {
            try {
                a = jogada.entrada.readInt(3);
                HouveExceção = true;
            } catch (RuntimeException e) {
                System.out.println("Entrada invalida!");
            }
        }
        return a;
    }


    /**
     * Esse método auxilia no loop do jogo, limpando o tabuleiro, checando se houve vitória ou empate.
     * Além disso, ele chama os métodos que salvam as informações dos jogadores.
     * @param jogo Recebe um objeto jogo.
     */
    public void rodando(Jogo jogo){
        int k, p = 0;
        do {
            k = 1;
            if(p == 0){
                LimparTabuleiro();
            }
            ImprimirTabuleiro();
            while (k <= 2 && -1 == checarVitoria(k - 2, p)) {
                jogada.Jogar(jogo, k);
                k++;
                p++;
            }
        }
        while (-1 == jogo.checarVitoria(k - 2, p));
        int resultado = jogo.checarVitoria(k - 2, p);
        if(jogo.checarVitoria(k - 2, p) == 1){
            System.out.println("Vitória do jogador " + (k - 1) + "!!!");
        }
        else{
            System.out.println("Deu Velha!!! ");
        }
        jogo.exibirResultado(k-2,resultado);
        GerenciaJogadoresArquivo.salvarJogador(jogo.jogadores.get(0));
        GerenciaJogadoresArquivo.salvarJogador(jogo.jogadores.get(1));
        GerenciaJogadoresArrayList.salvarJogador(jogo.jogadores.get(0));
        GerenciaJogadoresArrayList.salvarJogador(jogo.jogadores.get(1));
    }
    /**
     * Função responsável pela opção de jogar com um bot.
     * @param jogo Recebe como paramêtro um objeto do tipo jogo.
     */
    public void jogarComBot(Jogo jogo){
        Bot bot = new Bot();
        int k, p = 0;
        do {
            k = 1;
            if(p == 0){
                LimparTabuleiro();
            }
            ImprimirTabuleiro();
            while (k <= 2 && -1 == checarVitoria(k - 2, p)) {
                switch (k){
                    case 1:
                        jogada.Jogar(jogo, k);
                        k++;
                        p++;
                        break;
                    case 2:
                        System.out.println("Bot: ");
                        bot.JogadaBot(jogo);
                        k++;
                        p++;
                        break;
                    default:
                        break;
                }
                System.out.println(k);
            }
        }
        while (-1 == jogo.checarVitoria(k - 2, p));
        int resultado = jogo.checarVitoria(k - 2, p);
        if(jogo.checarVitoria(k - 2, p) == 1){
            System.out.println("Vitória do jogador " + (k - 1) + "!!!");
        }
        else{
            System.out.println("Deu Velha!!! ");
        }
        jogo.exibirResultado(k-2,resultado);
    }
    /**
     * Esta classe é responsável por checar se houve vitória no jogo.
     * @param jogadorAtual Indica qual jogador está jogando no momento.
     * @param p Indica o turno do jogo.
     * @return 1 caso houve vitória, -1 caso não houve vitória ou empate, e 0 caso houve empate.
     */
    public int checarVitoria(int jogadorAtual, int p) {
        int i = 0;
        while (i < 3) {
            if (!getElementos()[i][0].equals(" ") && !getElementos()[i][1].equals(" ") && !getElementos()[i][2].equals(" ")) {
                if (getElementos()[i][0].equals(getElementos()[i][1]) && getElementos()[i][1].equals(getElementos()[i][2]) && getElementos()[i][0].equals(getElementos()[i][2])) {
                    return 1;
                }
            }
            i++;
        }
        i = 0;
        while (i < 3) {
            if (!getElementos()[0][i].equals(" ") && !getElementos()[1][i].equals(" ") && !getElementos()[2][i].equals(" ")) {
                if (getElementos()[0][i].equals(getElementos()[1][i]) && getElementos()[1][i].equals(getElementos()[2][i]) && getElementos()[0][i].equals(getElementos()[2][i])) {
                    return 1;
                }
            }
            i++;
        }
        if (!getElementos()[0][0].equals(" ") && !getElementos()[1][1].equals(" ") && !getElementos()[2][2].equals(" ")){
            if (getElementos()[0][0].equals(getElementos()[1][1]) && getElementos()[1][1].equals(getElementos()[2][2]) && getElementos()[0][0].equals(getElementos()[2][2])) {
                return 1;
            }
        }
        if (!getElementos()[0][2].equals(" ") && !getElementos()[1][1].equals(" ") && !getElementos()[2][0].equals(" ")){
            if (getElementos()[0][2].equals(getElementos()[1][1]) && getElementos()[1][1].equals(getElementos()[2][0]) && getElementos()[0][2].equals(getElementos()[2][0])) {
                return 1;
            }
        }
        int vazio = 9;
        for(int k = 0; k < 3; k++){
            for(int l = 0; l < 3; l++){
                if(!getElementos()[k][l].equals(" ")) {
                    vazio--;
                }
            }
        }
        if (vazio == 0){
            return 0;
        }
        return -1;
    }

    /**
     * Exibe os resultados do jogo, a pontuação dos jogadores e seus nomes.
     * @param player o numero do jogador.
     * @param resultado a pontuação do jogador.
     */
    public void exibirResultado(int player, int resultado) {
        if(resultado == 1) {
            jogadores.get(player).incrementarPontuacao();
        }
        System.out.println("Placar:");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ": " + jogador.getPontuacao() + " pontos");
        }
        System.out.println(player);
    }

}



