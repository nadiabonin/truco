public class Carta {
    //lista de naispe
    public enum Naipe {
        OUROS, ESPADAS, COPAS, PAUS
    }
    //Lista de valores
    public enum Valor {
        QUATRO, CINCO, SEIS, SETE, QUEEN, JACK, KING, AS, DOIS, TRES
    } 
    //atributos privados
    private Valor valor;
    private Naipe naipe;
    private int forca;//força a base da carta (0 a 9) se a carta é mais forte ou mais fraca
    //contrutor
    public Carta (Valor valor, Naipe naipe){
        this.valor = valor;
        this.naipe = naipe;
        this.forca = valor.ordinal(); // retorna a posição no enum
    }
    //le os atributos
    public Valor getValor(){
        return valor;
    }
    public Naipe getNaipe(){
        return naipe;
    }
    public int getForca(){
        return forca;
    }
    //permite definir a forçar a manilha
    public void setForca(int forca){
        this.forca = forca;
    }
    
    //tostring imprime a carta
    @Override
    public String toString(){
        String[] nomeValor = {"4","5","6","7","Q","J","K","A","2","3"};
        String[] nomeNaipe = {"Ouros","Espadas","Copas","Paus"};
        return nomeValor[valor.ordinal()] + " de " + nomeNaipe[naipe.ordinal()];
    }
    
}