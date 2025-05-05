import java.io.*;
import java.net.*;

public class Echoclient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Connected to Echo Server. Type messages:");

            String message;
            while ((message = userInput.readLine()) != null) {
                out.println(message);
                String response = in.readLine();
                System.out.println(response);
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Connection closed.");
        }
    }
}

