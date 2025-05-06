import java.net.*;
import java.util.Scanner;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(12345);
        byte[] buffer = new byte[1024];
        Scanner scanner = new Scanner(System.in);

        
        InetAddress[] clientAddress = new InetAddress[1];
        int[] clientPort = new int[1];

        
        Thread receiveThread = new Thread(() -> {
            try {
                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);

                    String msg = new String(packet.getData(), 0, packet.getLength());
                    clientAddress[0] = packet.getAddress();
                    clientPort[0] = packet.getPort();

                    System.out.println("Client: " + msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread sendThread = new Thread(() -> {
            try {
                while (true) {
                    String message = scanner.nextLine();
                    if (clientAddress[0] != null) {
                        byte[] sendData = message.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress[0], clientPort[0]);
                        socket.send(sendPacket);
                    } else {
                        System.out.println("Waiting for client to send first message...");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        receiveThread.start();
        sendThread.start();
    }
}
