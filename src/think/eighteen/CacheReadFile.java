package think.eighteen;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author z
 **/
public class CacheReadFile {

    private void checkFileExists(File file) throws FileNotFoundException {
        if (file.exists()) {
            return;
        }
        throw new  FileNotFoundException("file not exists");
    }

    public Map<Integer, String> lineNumberMapString(File file) throws IOException {
        checkFileExists(file);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String readLine;
            int lineNumber = 1;
            Map<Integer, String> lineString = new HashMap<>();
            while ((readLine = bufferedReader.readLine()) != null) {
                lineString.put(lineNumber++, readLine);
            }
            return lineString;
        }
    }

    public String string(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return new String(fileInputStream.readAllBytes());
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("mysql.properties");
        CacheReadFile cacheReadFile = new CacheReadFile();
        var result = cacheReadFile.lineNumberMapString(file);
        result.forEach((k, v)-> System.out.println("line: " + k + ", content: " + v));
        System.out.println(cacheReadFile.string(file));
    }
}
