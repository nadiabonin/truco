import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> mao; //mao do meliante
    
    //contrutor
    public Jogador (String nome){
        this.nome =nome;
        this.mao = new ArrayList<>();
    }
    
    //prenenche a mao
    public void receberCarta(Carta carta){
        mao.add(carta);
    }
    //recebe uma escolha 123 joga uma carta na mesa e remove da mao
    public Carta jogarCarta(int posicao){
        if(posicao<0||posicao>=mao.size()){
            System.out.println("só as que tu tem na mao burro.");
            return null;
        }
        return mao.remove(posicao);
    }
    //mostra mao
    public void limparMao(){
        mao.clear();
    }
    //getss
    public String getNome(){
        return nome;
    }
        public List<Carta> getMao(){
        return mao;
    }
    public void mostrarMao(){
        System.out.println("\nCartas de " + nome + ":");
        for(int i = 0; i < mao.size(); i++){
            System.out.println("[" + i + "] " + mao.get(i));
    }
}
}