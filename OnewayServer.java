import java.util.*;
import java.net.*;
import java.io.*;

public class OnewayServer{
    public OnewayServer() throws Exception{
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server is running");
        Socket socket = ss.accept();

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String msg = in_socket.readLine();
        System.out.println("Client says = "+msg);
    }
    public static void main(String[] args){
        try {
            new OnewayServer();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}