import java.net.*;
import java.io.*;

public class ConecxaoJogador{
    private Socket socket;
    private PrintWriter saida; //servidor manda mensagem pro cliente
    private BufferdReader entrada; //servidor recebe mensagem do cliente
    private Jogador jogador;
    private Equipe equipe;
    
    public ConexaoJogador(Socket socket, Jogador jogador) throws IOException{
        
    }
}