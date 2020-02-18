package se.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author zhangyaowen
 */
public class TestEof {
    public static void main(String[] args) throws IOException {
        DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("./src/se/io/TestEof.java")));
        while (inputStream.available() != 0) {
            System.out.println((char) inputStream.readByte());
        }
    }
}
