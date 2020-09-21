package think.eighteen;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @author z
 **/
public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        GetChannel channel = new GetChannel();
        channel.usingBuffer();
    }

    public void transferTo() throws IOException {
        FileChannel in = new FileInputStream("nio.txt").getChannel();
        FileChannel out = new FileOutputStream("nOu.txt").getChannel();
        in.transferTo(0, in.size(), out);
    }

    public void channelCopy() throws IOException {
        File inFile = new File("nio.txt");
        File outFile = new File("nOut.text");
        FileChannel in = new FileInputStream(inFile).getChannel();
        FileChannel out = new FileOutputStream(outFile).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        while (in.read(byteBuffer) != -1) {
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();
        }
    }

    public void channelReadWrite() throws IOException {
        File file = new File("nio.txt");
        FileChannel fileChannel = new FileOutputStream(file).getChannel();
        fileChannel.write(ByteBuffer.wrap("Some text ".getBytes()));
        fileChannel.close();
        fileChannel = new RandomAccessFile(file, "rw").getChannel();
        fileChannel.position(fileChannel.size());
        fileChannel.write(ByteBuffer.wrap("Some more 🐍".getBytes()));
        fileChannel.close();
        fileChannel = new FileInputStream(file).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
        }
    }

    public void bufferedToText() throws IOException {
        File file = new File("data2.txt");

        FileChannel fOut = new FileOutputStream(file).getChannel();
        fOut.write(ByteBuffer.wrap("Some text 🐖".getBytes()));
        fOut.close();
        fOut = new FileInputStream(file).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        fOut.read(byteBuffer);
        byteBuffer.flip();
        // 输出原始字节
        System.out.println("out origin bytebuffer string: " + byteBuffer.asCharBuffer().toString());
        byteBuffer.rewind();
        String encoding = System.getProperty("file.encoding");
        // 输出时解码
        System.out.println("bytebuffer output Decode " + encoding + ": " + Charset.forName(encoding).decode(byteBuffer));

        fOut = new FileOutputStream(file).getChannel();
        // 写入时编码
        fOut.write(ByteBuffer.wrap("Some text 🦋 s".getBytes(StandardCharsets.UTF_16)));
        fOut.close();
        fOut = new FileInputStream("data2.txt").getChannel();
        byteBuffer.clear();
        fOut.read(byteBuffer);
        byteBuffer.flip();
        System.out.println("bytebuffer input encode UTF_16: " + byteBuffer.asCharBuffer());

        fOut = new FileOutputStream(file).getChannel();
        byteBuffer = ByteBuffer.allocate(BSIZE);
        // 使用 CharBuffer
        byteBuffer.asCharBuffer().put("Some text 😀");
        fOut.write(byteBuffer);
        fOut.close();
        fOut = new FileInputStream(file).getChannel();
        byteBuffer.clear();
        fOut.read(byteBuffer);
        byteBuffer.flip();
        System.out.println("char buffer put: " + byteBuffer.asCharBuffer());
    }

    public void availableCharsets() {
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        Iterator<String> iterator = charSets.keySet().iterator();
        while (iterator.hasNext()) {
            String charset = iterator.next();
            System.out.println(charset);
            Iterator aliases = charSets.get(charset).aliases().iterator();;
            if (aliases.hasNext()) {
                System.out.println(" : ");
            }
            while (aliases.hasNext()) {
                System.out.println(aliases.next());
                if (aliases.hasNext()) {
                    System.out.println(". ");
                }
            }
        }
    }

    public void getData() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < byteBuffer.limit()) {
            if (byteBuffer.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i);
        byteBuffer.rewind();
        byteBuffer.asCharBuffer().put("Howdy!");
        char c;
        while ((c = byteBuffer.getChar()) != 0) {
            System.out.print(c + " ");
        }
        System.out.println();
        byteBuffer.rewind();
        byteBuffer.asShortBuffer().put((short) 412332);
        System.out.println(byteBuffer.getShort());
        byteBuffer.rewind();
        byteBuffer.asIntBuffer().put(9999999);
        System.out.println(byteBuffer.getInt());
        byteBuffer.rewind();
        byteBuffer.asLongBuffer().put(283292123);
        System.out.println(byteBuffer.getLong());
        byteBuffer.rewind();
        byteBuffer.asFloatBuffer().put(99471142);
        System.out.println(byteBuffer.getFloat());
        byteBuffer.rewind();
        byteBuffer.asDoubleBuffer().put(99471142);
        System.out.println(byteBuffer.getDouble());
        byteBuffer.rewind();
    }

    public void intBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(new int[]{11, 34, 23, 121, 3, 123, 1234, 1244});
        System.out.println(intBuffer.get(3));
        intBuffer.put(3, 111);
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(i);
        }
    }

    public void viewBuffers() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0 , 'a'});
        byteBuffer.rewind();
        System.out.println("Byte Buffer ");
        while (byteBuffer.hasRemaining()) {
            System.out.print(byteBuffer.position() + " > " + byteBuffer.get() + ". ");
        }
        System.out.println("Char Buffer ");
        CharBuffer charBuffer = byteBuffer.rewind().asCharBuffer();
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.position() + " > " + charBuffer.get() + ". ");
        }
        System.out.println("Float Buffer");
        FloatBuffer floatBuffer = byteBuffer.rewind().asFloatBuffer();
        while (floatBuffer.hasRemaining()) {
            System.out.print(floatBuffer.position() + " > " + floatBuffer.get() + ". ");
        }
        System.out.println("Int Buffer");
        IntBuffer intBuffer = byteBuffer.rewind().asIntBuffer();
        while (intBuffer.hasRemaining()) {
            System.out.print(floatBuffer.position() + " > " + intBuffer.get() + ". ");
        }
        System.out.println("Long Buffer");
        LongBuffer longBuffer = byteBuffer.rewind().asLongBuffer();
        while (longBuffer.hasRemaining()) {
            System.out.print(longBuffer.position() + " > " + longBuffer.get() + ". ");
        }
        System.out.println("Short Buffer");
        ShortBuffer shortBuffer = byteBuffer.rewind().asShortBuffer();
        while (shortBuffer.hasRemaining()) {
            System.out.print(shortBuffer.position() + " > " + shortBuffer.get() + ". ");
        }
        System.out.println("Double Buffer");
        DoubleBuffer doubleBuffer = byteBuffer.rewind().asDoubleBuffer();
        while (doubleBuffer.hasRemaining()) {
            System.out.print(doubleBuffer.position() + " > " + doubleBuffer.get() + ". ");
        }
    }

    public void endians() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[12]);
        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));
        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));
        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));
    }

    public void usingBuffer() {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(data.length * 2);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put(data);
        System.out.println(charBuffer.rewind());
        while (charBuffer.hasRemaining()) {
            charBuffer.mark();
            char c1 = charBuffer.get();
            char c2 = charBuffer.get();
            charBuffer.reset();
            charBuffer.put(c2).put(c1);
        }
        System.out.println(charBuffer.rewind());
    }
}
