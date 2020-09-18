package think.eighteen;

import java.io.*;

/**
 * @author z
 **/
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        var unicodeString = "🦋🐖🐎🐅🐕🦆🐥🐧早上h";
        StringReader stringReader = new StringReader(unicodeString);
        var br = new BufferedReader(stringReader);
        System.out.println(br.readLine());
    }
}
