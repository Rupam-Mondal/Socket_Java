import java.net.*;
import java.util.Scanner;

public class LogClientUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverIP = InetAddress.getLocalHost(); // or actual server IP
            Scanner sc = new Scanner(System.in);

            String os = System.getProperty("os.name");

            while (true) {
                System.out.print("Enter log message: ");
                String log = sc.nextLine();

                String fullMessage = "OS: " + os + "\n" + log;
                byte[] data = fullMessage.getBytes();

                DatagramPacket packet = new DatagramPacket(data, data.length, serverIP, 6000);
                socket.send(packet);
            }
        } catch (Exception e) {
            System.out.println("Log Client Error: " + e);
        }
    }
}
