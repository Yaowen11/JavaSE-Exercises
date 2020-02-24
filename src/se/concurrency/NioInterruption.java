package se.concurrency;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class NioBlocked implements Runnable {
    private final SocketChannel sc;
    public NioBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println("ClosedByInterruptException");
        }  catch (AsynchronousCloseException e) {
            System.out.println("AsynchronousCloseException e");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/**
 * @author zhangyaowen
 */
public class NioInterruption {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
        SocketChannel socketChannel = SocketChannel.open(isa);
        SocketChannel socketChannel1 = SocketChannel.open(isa);
        Future<?> f = executorService.submit(new NioBlocked(socketChannel));
        executorService.execute(new NioBlocked(socketChannel1));
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(1);
        socketChannel1.close();
    }
}
