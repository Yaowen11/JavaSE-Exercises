package se.io.nio;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author zhangyaowen
 */
public class GZipCompress {
    public static void compress(String origin) throws IOException {
        System.out.println("Writing file");
        try (BufferedReader in = new BufferedReader(new FileReader(origin));
            BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")))) {
                int c;
                while ((c = in.read()) != -1) {
                    out.write(c);
                }
        }
    }

    public static void unzip(String compress) throws IOException {
        try (BufferedReader in =
                     new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(compress))))) {
            String s;
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        try {
            unzip("test.gz");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
