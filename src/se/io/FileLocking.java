package se.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyaowen
 */
public class FileLocking {

    public static void fileLocking() throws IOException, InterruptedException {
        FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        FileLock fileLock = fileOutputStream.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            fileLock.release();
            System.out.println("Released Lock");
        }
        fileOutputStream.close();
    }

    public static void fileScopeLocking() throws IOException, InterruptedException {

    }

    public static void main(String[] args) throws Exception {

    }


}
