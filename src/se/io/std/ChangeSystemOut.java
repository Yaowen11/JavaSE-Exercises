package se.io.std;

import java.io.PrintWriter;

/**
 * @author zhangyaowen
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(System.out)) {
            out.println("Hello, world");
        }
    }
}
