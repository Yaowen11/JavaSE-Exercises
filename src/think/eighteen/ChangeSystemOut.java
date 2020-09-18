package think.eighteen;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author z
 **/
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        out.println("hello world");
        out.flush();
    }
}
