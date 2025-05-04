import java.net.*;
import java.util.Scanner;

public class TwowayClientUDP {
    public TwowayClientUDP() throws Exception{
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter a message = ");
            String msg1 = sc.nextLine();
            byte[] buffer = msg1.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length , InetAddress.getLocalHost() , 3000);
            socket.send(packet);


            buffer = new byte[1500];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String msg = new String(buffer);
            System.out.println("Server says = "+msg);
        }
    }
    public static void main(String[] args) {
        try {
            new TwowayClientUDP();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
