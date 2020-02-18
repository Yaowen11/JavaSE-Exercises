package se.io.nio;

import java.nio.*;
import java.util.Arrays;

import static java.lang.System.out;
/**
 * @author zhangyaowen
 */
public class ByteBufferView {
    private static final int BUFF_SIZE = 1024;

    public static void bufferView() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(BUFF_SIZE);
        int i = 0;
        while (i++ < buffer.limit()) {
            if (buffer.get() != 0) {
                out.println("nonzero");
            }
        }
        out.print("i + " + i);
        buffer.rewind();
        buffer.asCharBuffer().put("Howdy!");
        char c;
        while ((c = buffer.getChar()) != 0) {
            out.println(c + " ");
        }
        out.println();
        buffer.rewind();
        buffer.asShortBuffer().put((short) 471142);
        out.println(buffer.getShort());
        buffer.rewind();
        buffer.asIntBuffer().put(99471142);
        out.println(buffer.getInt());
        buffer.asLongBuffer().put(298327323232L);
        out.println(buffer.getLong());
        buffer.rewind();
        buffer.asFloatBuffer().put(23.34f);
        out.println(buffer.getFloat());
        buffer.rewind();
        buffer.asDoubleBuffer().put(232.32424);
        out.println(buffer.getDouble());
        buffer.rewind();
    }

    public static void intBufferDemo() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(BUFF_SIZE);
        IntBuffer intBuffer = buffer.asIntBuffer();
        intBuffer.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        System.out.println(intBuffer.get(3));
        intBuffer.put(3, 19);
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(i);
        }
    }

    public static void viewBuffers() {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        buffer.rewind();
        out.print("Byte Buffer: ");
        while (buffer.hasRemaining()) {
            out.print(buffer.position() + " -> " + buffer.get() + ". ");
        }
        out.println();
        CharBuffer charBuffer = buffer.rewind().asCharBuffer();
        out.print("Char Buffer: ");
        while (charBuffer.hasRemaining()) {
            out.print(charBuffer.position() + " -> " + charBuffer.get() + ". ");
        }
        out.println();
        FloatBuffer floatBuffer = buffer.rewind().asFloatBuffer();
        out.print("Float or Int Buffer: ");
        while (floatBuffer.hasRemaining()) {
            out.print(floatBuffer.position() + " -> " + floatBuffer.get() + ". ");
        }
        out.println();
        ShortBuffer shortBuffer = buffer.rewind().asShortBuffer();
        out.print("Short Buffer: ");
        while (shortBuffer.hasRemaining()) {
            out.print(shortBuffer.position() + " -> " + shortBuffer.get() + ". ");
        }
        out.println();
        DoubleBuffer doubleBuffer = buffer.rewind().asDoubleBuffer();
        out.print("Double or Long Buffer: ");
        while (doubleBuffer.hasRemaining()) {
            out.print(doubleBuffer.position() + " -> " + doubleBuffer.get() + ". ");
        }
        out.println();
    }

    public static void changeBufferOrder() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        out.print(Arrays.toString(bb.array()));
    }

    public static void usingBuffers() {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer buffer = ByteBuffer.allocate(data.length * 2);
        CharBuffer charBuffer = buffer.asCharBuffer();
        charBuffer.put(data);
        out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        out.println();
        out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        out.println(charBuffer.rewind());
    }

    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }
    public static void main(String[] args) {
       viewBuffers();
       changeBufferOrder();
       usingBuffers();
    }
}
