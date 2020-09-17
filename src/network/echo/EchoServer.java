package network.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zyw
 * @date 2020/7/7 21:22
 */
public class EchoServer {

    private final ServerSocket serverSocket;

    public EchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void service() {
        while (true) {
            try (Socket socket = serverSocket.accept()) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                    System.out.println("New connection accepted " + socket.getInetAddress() + " : " + socket.getPort());
                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        System.out.println(msg);
                        writer.println("client input: " + msg);
                        if ("bye".equals(msg)) {
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer(8000).service();
    }
}
