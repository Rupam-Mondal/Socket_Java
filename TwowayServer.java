import java.io.*;
import java.net.*;
import java.net.Socket;
import java.util.Scanner;

public class TwowayServer{
    public TwowayServer() throws Exception{
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server started at port 3000");
        Socket socket = ss.accept();
        System.out.println("Client connected");
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        out_socket.println("Welcome client");
        out_socket.flush();
        while(true){
            String msg = in_socket.readLine();
            System.out.println("Client says = "+msg);
            System.out.println("Write something to client = ");
            String msg1 = sc.nextLine();
            out_socket.println(msg1);
            out_socket.flush();
        }
    }
    public static void main(String[] args) {
        try {
            new TwowayServer();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}