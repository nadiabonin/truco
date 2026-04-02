import java.util.ArrayList;
import java.util.List;

public class Equipe{
    private String nome;
    private List<Jogador> jogadores;
    private int pontos;

    //contructo
    public Equipe (String nome, Jogador jogador1, Jogador jogador2){
        this.nome = nome;
        this.pontos = 0;
        this.jogadores = new ArrayList<>();
        jogadores.add(jogador1);
        jogadores.add(jogador2);
    }

        public void addPontos(int quantidade){
        pontos +=quantidade;
    }

    public String getNome(){
        return nome;
    }
    
    public int getPontos(){
        return pontos;
    }
    
    public List<Jogador> getJogadores(){
        return jogadores;
    }
    //retorna um jogador rspeciffiqco pelo indice(01)
    public Jogador getJogador(int index){
        return jogadores.get(index);
    }

    @Override
        public String toString() {
        return nome + " ["
            + jogadores.get(0).getNome()
            + " & "
            + jogadores.get(1).getNome()
            + "] - "
            + pontos + " pontos";
    }
}