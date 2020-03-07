package se.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author zhangyaowen
 */
public class BufferToText {

    private static final int BUFF_SIZE = 1024;

    private String file;

    private ByteBuffer buffer = ByteBuffer.allocateDirect(BUFF_SIZE);

    BufferToText() {}

    BufferToText(String file) {
        this.file = file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    void writeToFile(String text) throws IOException {
        getFileOutputStreamChannel().write(ByteBuffer.wrap(text.getBytes()));
    }

    void writeToFileEncoding(String text) throws IOException {
        getFileOutputStreamChannel().write(ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8)));
    }

    String buffer2TextByOutputDecoding() throws IOException {
        getFileInputStreamChannel().read(buffer);
        buffer.flip();
        buffer.rewind();
        String result = Charset.forName(System.getProperty("file.encoding")).decode(buffer).toString();
        buffer.clear();
        return result;
    }

    private FileChannel getFileOutputStreamChannel() throws FileNotFoundException {
        return new FileOutputStream(file).getChannel();
    }

    private FileChannel getFileInputStreamChannel() throws FileNotFoundException {
        return new FileInputStream(file).getChannel();
    }

    public static void dump() throws IOException {
        FileChannel fileChannel = new FileOutputStream("data2.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("Some text".getBytes()));
        fileChannel.close();
        fileChannel = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFF_SIZE);
        fileChannel.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buffer));
        fileChannel = new FileOutputStream("data2.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("Some text".getBytes(StandardCharsets.UTF_16BE)));
        fileChannel.close();
        fileChannel = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fileChannel.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        fileChannel = new FileOutputStream("data2.txt").getChannel();
        buffer.asCharBuffer().put("Some text");
        fileChannel.write(buffer);
        fileChannel.close();
        fileChannel = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fileChannel.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }

    public static void main(String[] args) throws IOException {
        String utf8String = "缓冲器🌲 java nio";
        String file = "Logon.out";
        BufferToText bufferToText = new BufferToText(file);
        System.out.println(bufferToText.buffer2TextByOutputDecoding());
    }
}
