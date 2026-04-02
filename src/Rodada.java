import java.util.Scanner;

public class Rodada {
    private Equipe equipe1;
    private Equipe equipe2;    
    private Carta vira;
    private Scanner scanner;
    private Jogador[] ordemMesa;

    public Rodada(Equipe equipe1, Equipe equipe2, Scanner scanner){
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;
    this.scanner = scanner;

        Baralho baralho = new Baralho();
        baralho.embaralhar();
        this.vira = baralho.pegarCarta();

        // Rodada vira a carta
        this.vira = baralho.pegarCarta();

        //manda carta pros jogadores
        for (int i = 0; i < 3; i++) {
            equipe1.getJogador(0).receberCarta(baralho.pegarCarta());
            equipe2.getJogador(0).receberCarta(baralho.pegarCarta());
            equipe1.getJogador(1).receberCarta(baralho.pegarCarta());
            equipe2.getJogador(1).receberCarta(baralho.pegarCarta());
        }

        this.ordemMesa = new Jogador[]{
            equipe1.getJogador(0),
            equipe2.getJogador(0),
            equipe1.getJogador(1),
            equipe2.getJogador(1)
        };
        definirManilhas();
    }

    //defina quais cartas são as manilhas
    private void definirManilhas(){
        //pega a possiçao(o ordinal) no enum de um valor
        int posicaoVira = vira.getValor().ordinal();
        
        int posicaoManilha = (posicaoVira + 1) % Carta.Valor.values().length;

        Carta.Valor valorManilha = Carta.Valor.values()[posicaoManilha];

        System.out.println("\nVira: " + vira);
        System.out.println("Manilha: " + valorManilha);

        for(Equipe equipe : new Equipe[]{equipe1,equipe2}){
            for(Jogador jogador : equipe.getJogadores()){
                definirForcaManilha(jogador, valorManilha);
            }
        }

    }
    //muda a força das manilhas na mao do jogador
    private void definirForcaManilha(Jogador jogador, Carta.Valor valorManilha){
        for(Carta carta : jogador.getMao()){
            if(carta.getValor() == valorManilha){
                int forcaManilha = 10+carta.getNaipe().ordinal();
                carta.setForca(forcaManilha);
            }
        }
    }

    //jogador joga carta
    private Carta escolherCarta(Jogador jogador){
        jogador.mostrarMao();
        System.err.println("Escolha uma carta para jodar, entre 0, 1 ou 2.");

        int escolha = scanner.nextInt();
        
        while (escolha<0 || escolha>= jogador.getMao().size() /*|| escolha != int*/){
            System.out.println("Posição invalida! escolha novamente: ");
            escolha = scanner.nextInt();
        }
        return jogador.jogarCarta(escolha);
    }
    private Carta melhorCartaDaEquipe(Carta cartajogador1, Carta cartajogador2){
        if(cartajogador1.getForca()>=cartajogador2.getForca()){
            return cartajogador1;
        }
        return cartajogador2;
    }

    // rodada
    public Equipe jogar(){
        int vitorias1 = 0;
        int vitorias2 = 0;

        for(int numMao = 1; numMao <=3; numMao++){
            System.out.println("\n========MÃO "+numMao+"========");
            //cada jogador escolhe um carta
            Carta[] cartasJogadas =new Carta[4];
            for(int i = 0;i<4;i++){
                System.out.println("\n VEZ DE " + ordemMesa[i].getNome()+" da "+ getEquipeDojogador(i));
                System.out.println("\n Lembrando a manilha é "+ vira);
                cartasJogadas[i]=escolherCarta(ordemMesa[i]);
            }
            System.out.println("==== CARTAS JOGADAS=====");
            for(int i =0;i<4;i++){
                System.out.println(ordemMesa[i].getNome()+": "+cartasJogadas[i]);
            }
            //compara as acaryta
            Carta melhor1 = melhorCartaDaEquipe(cartasJogadas[0], cartasJogadas[2]);
            Carta melhor2 = melhorCartaDaEquipe(cartasJogadas[1], cartasJogadas[3]);
            System.out.println("\nMelhor carta" + equipe1.getNome()+"; "+melhor1);
            System.out.println("Melhor carta" + equipe2.getNome()+"; "+melhor2);
        
        int resultado = compararEquipes(melhor1, melhor2);
        if(resultado ==1){
            System.out.println("✓ " + equipe1.getNome() + " venceu a rodada +2 pontos!");
                vitorias1++;
        }else if (resultado == 2) {
                System.out.println("✓ " + equipe2.getNome() + " venceu rodada +2 pontos!");
                vitorias2++;
        }else{
            System.out.println("EMPATE!");
        }
        //ve se alguma equipe ja ganhou
        if(vitorias1==2||vitorias2==2) {
            break;
        }
    }


    System.out.println("========== FIM DA RODADA=========");
           if (vitorias1 > vitorias2) {
            System.out.println("🏆 " + equipe1.getNome() + " venceu a rodada!");
            return equipe1;
        } else if (vitorias2 > vitorias1) {
            System.out.println("🏆 " + equipe2.getNome() + " venceu a rodada!");
            return equipe2;
        } else {
            System.out.println("Rodada empatada!");
            return null;
        }
    }
    private String getEquipeDojogador(int posicaoMesa){
        if(posicaoMesa==0||posicaoMesa==2)
            return equipe1.getNome();
        return equipe2.getNome();
    }
    private int compararEquipes(Carta melhor1, Carta melhor2) {
        if (melhor1.getForca() > melhor2.getForca()) return 1;
        if (melhor2.getForca() > melhor1.getForca()) return 2;
        return 0;
    }
}
