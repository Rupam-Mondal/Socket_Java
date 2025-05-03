import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class OnewayClient {
    public OnewayClient() throws Exception{
        Socket socket = new Socket("localhost" , 3000);
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        out_socket.println("Hi server this is one way communication");
        out_socket.flush();
    }
    public static void main(String[] args) {
        try {
            new OnewayClient();
        } catch (Exception e) {
            System.out.println(e);
        }
    }   
}
