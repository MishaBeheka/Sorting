package my.dev.com.algoritms.small.examples.sockets;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketMethodPostExample {

    public static void main(String[] args) {
        try(Socket socket = new Socket("93.175.204.87", 8080)) {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            String jsonStr = "{\"firstName\": \"Misha\", \"lastName\": \"Beheka\"}";

            writer.println("POST /ping HTTP/1.1");
            writer.println("Host: 93.175.204.87");
            writer.println("Content-Type: application/json");
            writer.println("Content-Length: " + jsonStr.length());
            writer.println();
            writer.println(jsonStr);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
