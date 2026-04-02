import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        Jogador jogador1 = new Jogador("Aceu");//e1
        Jogador jogador2 = new Jogador("valdemir");//e2
        Jogador jogador3 = new Jogador("walter");//e1
        Jogador jogador4 = new Jogador("jurandir");//e2
        
        Equipe equipe1 = new Equipe("Equipe 1", jogador1, jogador3);
        Equipe equipe2 = new Equipe("Equipe 2", jogador2, jogador4);
        
        System.out.println("=== EQUIPES ===");
        System.out.println(equipe1);
        System.out.println(equipe2);


        Rodada rodada = new Rodada(equipe1, equipe2, scanner);
            Equipe vencedora = rodada.jogar();

            if (vencedora != null) {
                System.out.println("\nVencedora: " + vencedora);
            } else {
                System.out.println("\nRodada empatada!");
            }

            scanner.close();
        }
}
