package se.io.oio;

import se.io.oio.BufferedInputFile;

import java.io.*;

/**
 * @author zhangyaowen
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        try(BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("./src/se" +
                "/io/oio/BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null) {
                out.println(lineCount++ + ": " + s);
            }
            out.flush();
            System.out.println(BufferedInputFile.read(file));
        }
    }

}
