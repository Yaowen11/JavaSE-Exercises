package se.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhangyaowen
 */
public class BufferedInputFile {
    public static String read(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String s;
        StringBuilder builder = new StringBuilder();
        while ((s = in.readLine()) != null) {
            builder.append(s).append("\n");
        }
        in.close();
        return builder.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.println(read("preferences_tree.xml"));
    }
}
