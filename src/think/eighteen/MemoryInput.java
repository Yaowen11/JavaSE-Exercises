package think.eighteen;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author z
 **/
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("t🦋早鹞🐖");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.println(c);
        }
    }
}
