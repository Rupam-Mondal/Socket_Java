import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TwowayServerUDP {
    public TwowayServerUDP() throws Exception{
        DatagramSocket socket = new DatagramSocket(3000);
        System.out.println("Server started");
        Scanner sc = new Scanner(System.in);

        while(true){
            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String msg = new String(buffer);
            System.out.println("Client says = "+msg);

            System.out.println("Enter a message = ");
            String msg1 = sc.nextLine();
            buffer = msg1.getBytes();
            packet = new DatagramPacket(buffer, buffer.length , packet.getAddress() , packet.getPort());
            socket.send(packet);
        }
    }
    public static void main(String[] args) {
        try {
            new TwowayServerUDP();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
