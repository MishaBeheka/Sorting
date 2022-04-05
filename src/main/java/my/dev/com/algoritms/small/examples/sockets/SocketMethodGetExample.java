package my.dev.com.algoritms.small.examples.sockets;

import java.io.*;
import java.net.Socket;

public class SocketMethodGetExample {
    public static void main(String[] args) {
        //93.175.204.87
        try(Socket socket = new Socket("93.175.204.87", 8080);
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            printWriter.println("GET /morning?name=Misha" + " HTTP/1.1");
            printWriter.println("Host: 93.175.204.87");
            printWriter.println("X-Mood: cool");

            printWriter.println();
            printWriter.flush();
            reader.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
