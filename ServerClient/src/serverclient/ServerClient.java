package serverclient;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient {
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(1300);
        
        while(true){
        System.out.println("Server is listening...");
        Socket socket=server.accept();
        new Calculator(socket).start();
        
        }
    }
    }  

