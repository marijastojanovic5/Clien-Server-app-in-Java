package serverclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Calculator extends Thread {
    Socket socket;
    public Calculator(Socket socket){
        this.socket=socket;
        
    }
    
    @Override
    public void run(){
        super.run();
        try{
        InputStream input =socket.getInputStream();
        OutputStream output =socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        
        System.out.println("Server ocekuje obracanje klijenta");
        System.out.println("Klijent kaze: ");
        System.out.println(br.readLine());
        output.write("Sta hoces?\r\n".getBytes());
        
        String operacija =br.readLine();
        System.out.println("Klijent je odabrao: ");
        System.out.println(operacija);
        output.write("Unesi operand\r\n".getBytes());
        System.out.println("Operandi su: ");
        String operandi=br.readLine();
        System.out.println(operandi);
        int op1=Integer.parseInt(operandi.split(",")[0]);
        int op2=Integer.parseInt(operandi.split(",")[1]);
        
        String res=" ";
        switch(operacija){
            case "+":
                res=String.valueOf(op1+op2);
            break;
            case "-":
                res=String.valueOf(op1-op2);
            break;
            case "*":
                res=String.valueOf(op1*op2);
            break;
            case "/":
                res=String.valueOf(op1/op2);
            break;
        
    }
        
       output.write((res+"\r\n").getBytes());
        }catch(Exception ex){
        
        }
        
    } 
    
}
