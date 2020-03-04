package se.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author z
 */
public class FileChannelCopy {

    public static void main(String[] args) {
        String source = "preferences_tree.xml";
        FileChannelCopy fileChannelCopy = new FileChannelCopy();
        try {
            fileChannelCopy.copyUseTransferFrom(source, "target");
            fileChannelCopy.copyUseTransferTo(source, "target-file");
            fileChannelCopy.copyUseByteBuffer(source, "target-buffer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyUseTransferFrom(String source, String target) throws IOException
    {
        try(FileChannel sourceFileChannel = new FileInputStream(new File(source)).getChannel();
            FileChannel targetFileChannel = new FileOutputStream(new File(target)).getChannel()) {
            targetFileChannel.transferFrom(sourceFileChannel, 0, sourceFileChannel.size());
        }
    }

    public void copyUseTransferTo(String source, String target) throws IOException {
        try(FileChannel sourceFileChannel = new FileInputStream(new File(source)).getChannel();
            FileChannel targetFileChannel = new FileOutputStream(new File(target)).getChannel()) {
            sourceFileChannel.transferTo(0, sourceFileChannel.size(), targetFileChannel);
        }
    }

    public void copyUseByteBuffer(String source, String target) throws IOException {
        try(FileChannel sourceFileChannel = new FileInputStream(new File(source)).getChannel();
            FileChannel targetFileChannel = new FileOutputStream(new File(target)).getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (sourceFileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                targetFileChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        }
    }
}
