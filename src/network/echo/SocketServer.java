package network.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author z
 **/
public class SocketServer {

    public static void main(String[] args) {
        int availableProcess = Runtime.getRuntime().availableProcessors();
        int basePort = 10000;
        ExecutorService executor = Executors.newFixedThreadPool(availableProcess);
        SocketServer socketServer = new SocketServer();
        for (int i = 0; i < availableProcess; i++) {
            executor.execute(socketServer.run(basePort + i));
        }
    }

    public Runnable run(int port) {
        return () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.printf("server address: %s port: %d\n", serverSocket.getInetAddress().getHostName(), serverSocket.getLocalPort());
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.printf(
                            "new connection client remote server:%s, address %s, port:%s\n",
                            socket.getRemoteSocketAddress(),
                            socket.getInetAddress().getHostAddress(),
                            socket.getPort()
                    );
                    if (socket.isConnected()) {
                        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                             PrintWriter writer = new PrintWriter((new OutputStreamWriter(socket.getOutputStream())), true)) {
                            writer.println("server hi!");
                            String clientSay;
                            while ((clientSay = reader.readLine()) != null) {
                                if ("bye".equals(clientSay)) {
                                    writer.println("server say good bye!");
                                    socket.close();
                                }
                                writer.println("client said: '" + clientSay + "'");
                                System.out.println("client say: " + clientSay);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
