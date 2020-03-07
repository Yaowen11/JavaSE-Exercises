package se.io.nio.socket.echo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

class Process implements Runnable {
    public static final int SIZE = 1024;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(SIZE);
    private StringBuilder stringBuilder =  new StringBuilder();
    private SocketChannel socketChannel;
    Process(SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        stringBuilder.append("thread_id: ")
                .append(Thread.currentThread().getId())
                .append(" remote_addr: ")
                .append(socketChannel.getRemoteAddress().toString())
                .append(" receive message: ");
    }
    @Override
    public void run() {
        try{
            while ((socketChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                stringBuilder.append(StandardCharsets.UTF_8.decode(byteBuffer).toString());
                byteBuffer.clear();
            }
            System.out.println(stringBuilder.toString());
            byteBuffer.put(stringBuilder.toString().getBytes());
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
