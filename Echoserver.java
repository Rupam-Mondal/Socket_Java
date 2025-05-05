import java.io.*;
import java.net.*;

class ClientHandler extends Thread {
    Socket clientSocket;
    int clientNumber;

    public ClientHandler(Socket socket, int clientNumber) {
        this.clientSocket = socket;
        this.clientNumber = clientNumber;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Client " + clientNumber + ": " + msg);
                out.println("Echo from server to Client " + clientNumber + ": " + msg);
            }

            clientSocket.close();
            System.out.println("Client " + clientNumber + " disconnected");
        } catch (IOException e) {
            System.out.println("Client " + clientNumber + " disconnected");
        }
    }
}

public class Echoserver {
    int clientCount = 0;

    public Echoserver() throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Echo Server started on port 1234");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientCount++;
            System.out.println("Client " + clientCount + " connected");
            ClientHandler handler = new ClientHandler(clientSocket, clientCount);
            handler.start();
        }
    }

    public static void main(String[] args) {
        try {
            new Echoserver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
