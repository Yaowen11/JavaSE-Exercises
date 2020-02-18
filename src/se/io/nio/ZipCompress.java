package se.io.nio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.*;

/**
 * @author zhangyaowen
 */
public class ZipCompress {

    ZipCompress() {}

    public void compressZip(List<String> files, String target) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(target)); BufferedOutputStream out = new BufferedOutputStream(zos))
        {
            files.forEach((String file) -> {
                try {
                    BufferedReader in = new BufferedReader(new FileReader(file));
                    zos.putNextEntry(new ZipEntry(file));
                    String c;
                    while ((c = in.readLine()) != null) {
                        out.write(c.getBytes(StandardCharsets.UTF_8));
                        out.write(Character.LINE_SEPARATOR);
                    }
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public List<String> listZipFile(String zipFile) throws IOException {
        try (ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFile)))
        {
            List<String> files = new LinkedList<>();
            ZipEntry zipEntry;
            while ((zipEntry = inputStream.getNextEntry()) != null) {
                files.add(zipEntry.getName());
            }
            return files;
        }
    }

    public static void dump(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new CRC32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of java zipping");
        for (String arg : args) {
            System.out.println("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();
        System.out.println("Checksum: " + csum.getChecksum().getValue());
        System.out.print("Reading file: ");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new CRC32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry zipEntry;
        while ((zipEntry = in2.getNextEntry()) != null) {
            System.out.println("Reading file " + zipEntry);
            int x;
            while ((x = bis.read()) != -1) {
                System.out.write(x);
            }
        }
        if (args.length == 1) {
            System.out.println("Checksum: " + csumi.getChecksum().getValue());
            bis.close();
        }
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            System.out.println("File: " + ze2);
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> originFiles = new LinkedList<>();
        String targetZip = "my.zip";
        originFiles.add("BasicFileOutput.out");
        originFiles.add("Data.txt");
        originFiles.add("data3.txt");
        ZipCompress zipCompress = new ZipCompress();
        zipCompress.compressZip(originFiles, targetZip);
        List<String> fileList = zipCompress.listZipFile(targetZip);
        System.out.println(targetZip + " files: ");
        fileList.forEach(System.out::println);
    }
}
