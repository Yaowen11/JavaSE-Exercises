package se.io.nio.socket.echo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

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
            int readLength;
            while ((readLength = (socketChannel.read(byteBuffer))) != -1) {
                byteBuffer.flip();
                byte[] bytes = new byte[readLength];
                for (int i = 0; i < readLength; i++) {
                    bytes[i] = byteBuffer.get();
                }
                stringBuilder.append(new String(bytes));
                byteBuffer.clear();
            }
            System.out.println(stringBuilder.toString());
            socketChannel.write(byteBuffer.put(stringBuilder.toString().getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
