package se.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangyaowen
 */
public class ChannelCopy {
    private static final int BUFF_SIZE = 4096;


    void readAndWrite(FileChannel from, FileChannel to) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(BUFF_SIZE);
        while(from.read(buffer) != -1) {
            buffer.flip();
            to.write(buffer);
            buffer.clear();
        }
    }

    void transferTo(FileChannel from, FileChannel to) throws IOException {
        from.transferTo(0, from.size(), to);
    }

    public static void main(String[] args) throws IOException {
        int length = 2;
        if (args.length != length) {
            System.out.println("arguments: source file dest file");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();

    }
}
