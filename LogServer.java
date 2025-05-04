import java.io.*;
import java.net.*;

public class LogServer {
    public LogServer() throws Exception{
        DatagramSocket socket = new DatagramSocket(6000);
        FileWriter logWriter = new FileWriter("logs.txt", true);
        System.out.println("Log Server started...");
        while(true){
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String log = new String(buffer);
            String clientIP = packet.getAddress().getHostAddress();
            int clientPort = packet.getPort();
            String logentry = String.format("[IP : %s | port:%d] %s", clientIP , clientPort , log.trim());
            System.out.println(logentry);
            logWriter.write(logentry + "\n");
            logWriter.flush();
        }
    }
    public static void main(String[] args) {
        try {
            new LogServer();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
