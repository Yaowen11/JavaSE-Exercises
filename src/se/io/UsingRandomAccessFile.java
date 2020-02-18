package se.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author zhangyaowen
 */
public class UsingRandomAccessFile {
    static String file = "rtest.data";
    static final int END = 7;
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < END; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        for (int i = 0; i < END; i++) {
            randomAccessFile.writeDouble(i * 1.414 );
        }
        randomAccessFile.writeUTF("The end of the file");
        randomAccessFile.close();
        display();
        randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(5 * 8);
        randomAccessFile.writeDouble(47.0001);
        randomAccessFile.close();
        display();
    }
}
