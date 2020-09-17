package network.echo;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author zyw
 * @date 2020/7/7 21:29
 */
public class EchoClient {

    private final Socket socket;

    public EchoClient(InetSocketAddress serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress.getHostName(), serverAddress.getPort(), InetAddress.getLocalHost(), port);
    }

    public void talk() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        while ((msg = localReader.readLine()) != null) {
            System.out.println("stand io input: " + msg);
            writer.println(msg);
            System.out.println(reader.readLine());
            if ("bye".equals(msg)) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoClient(new InetSocketAddress("localhost", 8000), 11222).talk();
    }
}
