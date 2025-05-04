import java.net.*;
import java.io.*;

public class MathServer{
    public MathServer() throws Exception{
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server started");
        Socket socket = ss.accept();
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        while(true){
            out_socket.println("1. Addition 2.substraction 3.Division");
            out_socket.flush();
            int num = Integer.parseInt(in_socket.readLine());
            System.out.println("Client choosed = "+num);
            int num1 = Integer.parseInt(in_socket.readLine());
            System.out.println("First number = "+num1);
            int num2 = Integer.parseInt(in_socket.readLine());
            System.out.println("Second number = "+num2);
            switch (num) {
                case 1:
                    int result = num1 + num2;
                    out_socket.println(result);
                    out_socket.flush();
                    break;
            
                default:
                    break;
            }

        }
    }
    public static void main(String[] args){
        try {
            new MathServer();
        } catch (Exception e) {
            
        }
    }
}