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
                Socket socket;
                while (true) {
                    socket = serverSocket.accept();
                    System.out.printf(
                            "new connection client remote server:%s, address %s, port:%s\n",
                            socket.getRemoteSocketAddress(),
                            socket.getInetAddress().getHostAddress(),
                            socket.getPort()
                    );
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                        if ("bye".equals(reader.readLine())) {
                            writer.write("good bye!");
                            writer.flush();
                            socket.close();
                        }
                        writer.write("your said: '" + reader.readLine() + "'");
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
