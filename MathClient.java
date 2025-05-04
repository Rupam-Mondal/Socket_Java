import java.util.*;
import java.io.*;
import java.net.*;

public class MathClient{
    public MathClient() throws Exception{
        Socket socket = new Socket("localhost" , 3000);
        Scanner sc = new Scanner(System.in);
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        while (true) {
            System.out.println(in_socket.readLine());
            System.out.println("Enter your choice = ");
            int choice = sc.nextInt();
            out_socket.println(choice);
            out_socket.flush();

            System.out.println("Enter first num = ");
            int num1 = sc.nextInt();
            out_socket.println(num1);
            out_socket.flush();

            System.out.println("Enter second num = ");
            int num2 = sc.nextInt();
            out_socket.println(num2);
            out_socket.flush();


            System.out.println("Answer is = "+in_socket.readLine());
        }
    }
    public static void main(String[] args) {
        try {
            new MathClient();
        } catch (Exception e) {
            
        }
    }
}