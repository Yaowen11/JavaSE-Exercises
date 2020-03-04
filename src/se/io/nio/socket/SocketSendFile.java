package se.io.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SocketServer {

    private static final int SERVER_LISTEN_PORT = 9000;

    private static final String ADDRESS = "localhost";

    private ServerSocketChannel serverSocketChannel;

    public SocketServer() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(ADDRESS, SERVER_LISTEN_PORT));
    }

    public void run() throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SocketChannel socketChannel;
        while ((socketChannel = serverSocketChannel.accept()) != null) {
             executorService.submit(new Process(socketChannel));
        }
    }
}

class Process implements Runnable {
    private SocketChannel socketChannel;
    Process(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }
    @Override
    public void run() {
        StringBuilder stringBuilder = null;
        try {
            stringBuilder = new StringBuilder("socket channel remote address: ")
                    .append(socketChannel.getRemoteAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stringBuilder.append("receive message: ");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        List<Byte> origin = new ArrayList<>();
        while ((socketChannel.read(byteBuffer) != -1)) {
            byteBuffer.flip();
            stringBuilder.append(byteBuffer);
            byteBuffer.clear();
        }

        socketChannel.write();
    }
}
/**
 * @author z
 */
public class SocketSendFile {

    private static final int SERVER_PORT = 9000;



    public SocketSendFile() throws IOException  {

    }

    public

    public static void main(String[] args) {

    }
}
