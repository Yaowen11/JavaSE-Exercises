package se.io.oio;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author zhangyaowen
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("preferences_tree.xml").getBytes(StandardCharsets.UTF_8)));
        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }
}
