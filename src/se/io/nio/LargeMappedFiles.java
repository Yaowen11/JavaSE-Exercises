package se.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangyaowen
 */
public class LargeMappedFiles {

    static int LENGTH = 0x8FFFFFF;

    public static void memoryMapping() throws IOException  {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte)'x');
        }
        System.out.println("Finished writing");
        for (int i = LENGTH/2; i < LENGTH/2 + 6; i++) {
            System.out.println((char)out.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        try {
            memoryMapping();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
