package network.echo;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author z
 **/
public class SocketClient {

    private final String host = "localhost";

    private List<InetSocketAddress> socketAddressList = List.of(
            new InetSocketAddress(host, 10000),
            new InetSocketAddress(host, 10001),
            new InetSocketAddress(host, 10002),
            new InetSocketAddress(host, 10003),
            new InetSocketAddress(host, 10004),
            new InetSocketAddress(host, 10005)
    );

    public static void main(String[] args) {
        int process = Runtime.getRuntime().availableProcessors();
        int basePort = 20000;
        ExecutorService executor = Executors.newFixedThreadPool(process);
        SocketClient socketClient = new SocketClient();
        for (int i = 0; i < process; i++) {
            executor.execute(socketClient.run(socketClient.randSocketAddress(), basePort + i));
        }
    }

    public Runnable run(InetSocketAddress serverAddress, int port) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    try(Socket socket = new Socket(serverAddress.getHostName(), serverAddress.getPort(),
                            InetAddress.getByName(host), port)) {
                        if (socket.isConnected()) {
                            InetSocketAddress serverAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
                            System.out.printf("connection success server address: %s, port: %d\n", serverAddr.getAddress(), serverAddr.getPort());
                            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                                bufferedWriter.write("hi! current time " + LocalDateTime.now());
                                bufferedWriter.flush();
                                bufferedWriter.write("bye");
                                String serverOutput;
                                while ((serverOutput = bufferedReader.readLine()) != null) {
                                    System.out.println("server out: " + serverOutput);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private InetSocketAddress randSocketAddress() {
        return socketAddressList.get(new Random().nextInt(socketAddressList.size()));
    }
}
