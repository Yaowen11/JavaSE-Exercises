package se.io;

import se.io.oio.BufferedInputFile;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author z
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("prlog.http"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
