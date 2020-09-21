package think.eighteen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author z
 **/
public class FileLockDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileLockDemo fileLockDemo = new FileLockDemo();
        fileLockDemo.fileLocking();
        fileLockDemo.fileLockMapping();
    }

    void fileLocking() throws IOException, InterruptedException {
        File file = new File("fileLock.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileLock fileLock = fileOutputStream.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("Locked File, lock type: " + fileLock.isShared());
            TimeUnit.MILLISECONDS.sleep(100);
            fileLock.release();
            System.out.println("Released lock");
        }
        fileOutputStream.close();
    }

    void fileLockMapping() throws IOException, InterruptedException {
        FileChannel fileChannel = new RandomAccessFile("test.dat", "rw").getChannel();
        int length = 0x8FFFFFF;
        MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        class LockAndModify extends Thread {

            private final ByteBuffer buffer;

            private final int start;

            private final int end;

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
        new LockAndModify(out, 0, length / 3);
        new LockAndModify(out, length/2, length/2 + length/4);
    }
}
