import java.net.*;

public class ServerBitstaff {
    public static final String FLAG = "01111110";

    public static String bitUnstuff(String data) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            result.append(c);
            if (c == '1') {
                count++;
                if (count == 5 && i + 1 < data.length() && data.charAt(i + 1) == '0') {
                    i++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(12345);
        byte[] buffer = new byte[1024];

        System.out.println("Server is running...");

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received frame: " + received);

        if (received.startsWith(FLAG) && received.endsWith(FLAG)) {
            String s = received.substring(FLAG.length(), received.length() - FLAG.length());
            String original = bitUnstuff(s);
            System.out.println("Unstuffed (original message): " + original);
        } else {
            System.out.println("Invalid frame: Missing FLAGs.");
        }

        socket.close();
    }
}
