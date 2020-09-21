package think.eighteen;

import java.io.*;
import java.util.zip.*;

/**
 * @author z
 **/
public class CompressDemo {

    public static void main(String[] args) throws IOException {
        CompressDemo compressDemo = new CompressDemo();
        compressDemo.gzipCompress();
    }

    void gzipCompress() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("prlog.http")));
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
    }

    void zipCompress() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.zip");
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        BufferedOutputStream outputStream = new BufferedOutputStream(zipOutputStream);
        zipOutputStream.setComment("A test of Java Zipping");
        String[] strings = {"this", "is", "a", "string"};
        for (String s : strings) {
            BufferedReader in = new BufferedReader(new FileReader(s));
            zipOutputStream.putNextEntry(new ZipEntry(s));
            int c;
            while ((c = in.read()) != -1) {
                outputStream.write(c);
            }
            in.close();
            outputStream.flush();
        }
        outputStream.close();
        System.out.println("Checksum: " + checkedOutputStream.getChecksum().getValue());
        System.out.println("Reading file");
        File file;
        FileInputStream fileInputStream = new FileInputStream("test.zip");
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        ZipInputStream inputStream = new ZipInputStream(checkedInputStream);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ZipEntry zipEntry;
        while ((zipEntry = inputStream.getNextEntry()) != null) {
            System.out.println("Reading file " + zipEntry);
            int x;
            while ((x = bufferedInputStream.read()) != -1) {
                System.out.write(x);
            }
        }

    }
}
