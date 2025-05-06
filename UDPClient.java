import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 12345;
        Scanner scanner = new Scanner(System.in);
        byte[] buffer = new byte[1024];

        Thread receiveThread = new Thread(() -> {
            try {
                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    String msg = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Server: " + msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread sendThread = new Thread(() -> {
            try {
                while (true) {
                    String message = scanner.nextLine();
                    byte[] sendData = message.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                    socket.send(sendPacket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        receiveThread.start();
        sendThread.start();
    }
}

