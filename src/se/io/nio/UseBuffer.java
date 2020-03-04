package se.io.nio;

import java.nio.IntBuffer;

/**
 * @author z
 */
public class UseBuffer {
    
    private IntBuffer intBuffer = IntBuffer.allocate(20);

    public UseBuffer() {

    }

    public static void main(String[] args) {
        UseBuffer useBuffer = new UseBuffer();
        useBuffer.dumpBufferInfo("allocate");
        useBuffer.dumpPutBuffer();
        useBuffer.dumpFlipBuffer();
        useBuffer.dumpReadBuffer();
        useBuffer.dumpRewindBuffer();
        useBuffer.dumpMarkResetBuffer();
    }


    private void dumpBufferInfo(String info) {
        System.out.println("-------" + info + "------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

    private void dumpPutBuffer() {
        int end = 5;
        for (int i = 0; i < end; i++) {
            intBuffer.put(i);
        }
        dumpBufferInfo("put");
    }

    private void dumpFlipBuffer() {
        intBuffer.flip();
        dumpBufferInfo("flip");
    }

    private void dumpReadBuffer() {
        for (int i = 0; i < 2; i++) {
            int j = intBuffer.get();
            System.out.println("j=" + j);
        }
        dumpBufferInfo("read");
        for (int i = 0; i < 3; i++) {
            int j = intBuffer.get();
            System.out.println("j=" + j);
        }
    }

    private void dumpRewindBuffer() {
        intBuffer.rewind();
        dumpBufferInfo("rewind");
        for (int i = 0; i < 5; i++) {
            System.out.println("j=" + intBuffer.get());
        }
        intBuffer.rewind();
    }
    
    private void dumpMarkResetBuffer() {
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());
        intBuffer.mark();
        dumpBufferInfo("mark");
        intBuffer.reset();
        dumpBufferInfo("reset");
        for (int i = 2; i < 5; i++) {
            int j = intBuffer.get();
            System.out.println("j=" + j);
        }

    }
}
