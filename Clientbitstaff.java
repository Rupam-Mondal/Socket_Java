import java.net.*;
import java.util.Scanner;

public class Clientbitstaff {
    public static final String FLAG = "01111110";

    public static String bitStuff(String data) {
        StringBuilder s = new StringBuilder();
        int c = 0;
        for(int i = 0 ; i < data.length() ; i++){
            s.append(data.charAt(i));
            if(data.charAt(i) == '1'){
                c++;
                if(c == 5){
                    s.append('0');
                    c = 0;
                }
                else{
                    c = 0;
                }
            }
        }
        return s.toString();
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter binary message: ");
        String message = scanner.nextLine();

        String stuffed = bitStuff(message);
        String framedMessage = FLAG + stuffed + FLAG;

        byte[] data = framedMessage.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 12345);
        socket.send(packet);

        System.out.println("Sent (with header/trailer): " + framedMessage);

        socket.close();
    }
}
