package se.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author zhangyaowen
 */
public class LockingMappedFiles {
    static final int LENGTH = 0x8ffffff;
    static FileChannel fileChannel;
    private static class LockAndModify extends Thread {
        private ByteBuffer buffer;
        private Integer start;
        private Integer end;
        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buffer = mbb.slice();
            start();
        }
        @Override
        public void run() {
            try {
                FileLock fileLock = fileChannel.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                while (buffer.position() < buffer.limit() - 1) {
                    buffer.put((byte)(buffer.get() + 1));
                }
                fileLock.release();
                System.out.println("Released: " + start + " to " + end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
