import java.net.*;
import java.util.Scanner;

public class OnewayclientUDP {
    public OnewayclientUDP() throws Exception{
        DatagramSocket socket = new DatagramSocket();
        System.out.println("Enter something = ");
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        byte[] buffer = msg.getBytes();
        int port = 3000;
        InetAddress ip = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length , ip , port);
        socket.send(packet);
    }
    public static void main(String[] args) {
        try {
            new OnewayclientUDP();
        } catch (Exception e) {
            
        }
    }
}
