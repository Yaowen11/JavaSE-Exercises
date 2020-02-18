package se.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyaowen
 */
public class GetChannel {
    private static final int BUFF_SIZE = 1024;
    public static void main(String[] args) throws Exception {
        FileChannel fileChannel = new FileOutputStream("data.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("Some text ".getBytes()));
        fileChannel.close();
        fileChannel = new RandomAccessFile("data.txt", "rw").getChannel();
        fileChannel.position(fileChannel.size());
        fileChannel.write(ByteBuffer.wrap("Some more".getBytes()));
        fileChannel.close();
        fileChannel = new FileInputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFF_SIZE);
        fileChannel.read(buffer);
        buffer.flip();
        List<Character> characterList = new LinkedList<>();
        while (buffer.hasRemaining()) {
            char tmp = (char) buffer.get();
            System.out.print(tmp);
            characterList.add(tmp);
        }
        System.out.println();
        characterList.forEach(System.out::print);
    }
}
