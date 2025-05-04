import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class OnewayserverUDP {
    public OnewayserverUDP() throws Exception{
        DatagramSocket socket = new DatagramSocket(3000);
        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        String msg = new String(buffer);
        System.out.println(msg);
    }
    public static void main(String[] args) {
        try {
            new OnewayserverUDP();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
