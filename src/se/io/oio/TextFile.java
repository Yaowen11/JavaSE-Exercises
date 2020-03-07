package se.io.oio;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author zhangyaowen
 */
public class TextFile extends ArrayList<String> {

    public static String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile())))
            {
                String s;
                while ((s = in.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return stringBuilder.toString();
    }

    public static void write(String fileName, String text) {
        try {
            try(PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile()))
            {
                out.print(text);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if ("".equals(get(0))) {
            remove(0);
        }
    }

    TextFile(String filName) {
        this(filName, "\n");
    }

    void write(String fileName) {
        try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile()))
        {
            for (String item: this) {
                out.println(item);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        String fileName = "./src/se/io/oio/TextFile.java";
        String file = read(fileName);
        write("test.txt", file);
        TextFile textFile = new TextFile("test.txt");
        textFile.write("test2.txt");
        TreeSet<String> words = new TreeSet<>(new TextFile(fileName, "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
