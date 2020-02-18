package se.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author zhangyaowen
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        try (BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile)))
        {
            byte[] data = new byte[bf.available()];
            bf.read();
            return data;
        }
    }
    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsolutePath());
    }
    public static void main(String[] args) throws IOException {
        System.out.println(new String(read(new File("rtest.data"))));
    }
}
