package se.io.nio.socket.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

class SocketClient implements Runnable {

    private SocketChannel client;

    private ByteBuffer buffer = ByteBuffer.allocate(Process.SIZE);

    private String send;

    SocketClient(String send) throws IOException {
        this.send = send;
        this.client = SocketChannel.open(new InetSocketAddress(SocketServer.ADDRESS, SocketServer.SERVER_LISTEN_PORT));
    }

    @Override
    public void run() {
        try {
            send(send);
            buffer.clear();
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String s) throws IOException {
        client.write(buffer.put(s.getBytes(StandardCharsets.UTF_8)));
    }

    public void receive() throws IOException {
        int readLength;
        while ((readLength = client.read(buffer)) != -1) {
            byte[] bytes = new byte[readLength];
            for (int i = 0; i < readLength; i++) {
                bytes[i] = buffer.get();
            }
            System.out.println(new String(bytes));
        }
    }
}
