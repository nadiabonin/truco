import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho{
    //list é uma lista dinamica
    private List<Carta> cartas;
    //construtor
    public Baralho(){
        cartas = new ArrayList<>();
        //dois laços, o primeiro decide o naipe e o segundo o valor, paus 4,5,6,7,Q,J,K,A,2,3 ESPADA....
        for(Carta.Naipe naipe : Carta.Naipe.values()){
            for(Carta.Valor valor : Carta.Valor.values()){
                //manda para a lista
                cartas.add(new Carta(valor, naipe));
            }
        }
    }
    public void embaralhar(){
        //comando dentro do import para trocar as posições dentro do cartas/baralho
        Collections.shuffle(cartas);
    }
    //remove a carta do topo e manda para a mao ou pra mesa
    public Carta pegarCarta(){
        return cartas.remove(0);//quando uma carta é retirada as outras pulam a posição para frente
    }
    public int quantidadeCartas(){
        return cartas.size();
    }
}