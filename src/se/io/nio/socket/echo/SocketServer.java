package se.io.nio.socket.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SocketServer {

    public static final int SERVER_LISTEN_PORT = 9000;

    public static final String ADDRESS = "localhost";

    private ServerSocketChannel serverSocketChannel;

    public SocketServer() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(ADDRESS, SERVER_LISTEN_PORT));
    }

    public void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SocketChannel socketChannel;
        try{
            while ((socketChannel = serverSocketChannel.accept()) != null) {
                executorService.execute(new Process(socketChannel));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer socketServer = new SocketServer();
        socketServer.run();
    }
}
