import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TwowayClient {
    public TwowayClient() throws Exception{
        Socket socket = new Socket("localhost" , 3000);
        Scanner sc = new Scanner(System.in);
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println(in_socket.readLine());
        while (true) {
            System.out.println("Enter a message = ");
            String msg = sc.nextLine();
            out_socket.println(msg);
            out_socket.flush();
            String msg1 = in_socket.readLine();
            System.out.println(msg1);
        }
    }
    public static void main(String[] args) {
        try {
            new TwowayClient();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
