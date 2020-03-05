package se.io.nio.socket.echo;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author z
 */
public class SocketEcho {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int size = 3;
        for (int i = 0; i < size; i++) {
            executorService.execute(new SocketClient("Client id is " + i));
        }
        executorService.shutdown();
    }
}
