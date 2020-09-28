package think.twenty;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadInterrupt {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> future = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        future.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new SleepBlocked());
        thread.start();
        thread.interrupt();test(new IOBlocked(System.in));
    }

    public static void interruptDump() throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException interruptedException) {
            System.out.println("throw interrupt exception");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {

    private final InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read()");
            in.read();
        } catch (IOException ioException) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(ioException);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }
    public SynchronizedBlocked() {
        new Thread(this::f).start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

class CloseResource {
    public static void dump() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();
        executorService.execute(new IOBlocked(socketInput));
        executorService.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        executorService.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + socketInput.getClass().getName());
        socketInput.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass());
        System.in.close();
    }
}

class NIOBlocked implements Runnable {

    private final SocketChannel socketChannel;

    public NIOBlocked(SocketChannel socketChannel) { this.socketChannel = socketChannel; }

    @Override
    public void run() {
        try {
            System.out.println("wating for read() in " + this);
            socketChannel.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println("Closed by interrupt exception");
        } catch (AsynchronousCloseException e) {
            System.out.println();
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}

class NioInterrupt {
    static void dump() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8080);
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
        SocketChannel socketChannel1 = SocketChannel.open(inetSocketAddress);
        Future<?> future = executorService.submit(new NIOBlocked(socketChannel));
        executorService.execute(new NIOBlocked(socketChannel1));
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(1);
        future.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        socketChannel1.close();
    }
}