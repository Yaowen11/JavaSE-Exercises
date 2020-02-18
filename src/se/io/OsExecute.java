package se.io;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyaowen
 */
public class OsExecute {

    private ProcessBuilder processBuilder = new ProcessBuilder();

    private static final String SPLIT = " ";

    public static final String EXECUTE_SUCCESSFUL = " execute success: ";

    public static final String EXECUTE_FAILED = " execute failed: ";

    OsExecute() {}

    public Map<String, List<String>> executeCommand(String command) throws IOException {
        Process process = processBuilder.command(command.split(SPLIT)).start();
        Map<String, List<String>> executeResultMap = new HashMap<>(1);
        List<String> result = new LinkedList<>();
        String tmp;
        try (InputStream failedInputStream = process.getErrorStream())
        {
            if (failedInputStream.available() != 0) {
                try (BufferedReader failedReader = new BufferedReader(new InputStreamReader(failedInputStream)))
                {
                    while ((tmp = failedReader.readLine()) != null) {
                        result.add(tmp);
                    }
                }
                executeResultMap.put(command + EXECUTE_FAILED, result);
            } else {
                try (BufferedReader successReader = new BufferedReader(new InputStreamReader(process.getInputStream())))
                {
                    while ((tmp = successReader.readLine()) != null) {
                        result.add(tmp);
                    }
                }
                executeResultMap.put(command + EXECUTE_SUCCESSFUL, result);
            }
        }
        return executeResultMap;
    }

    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (!command.startsWith("CMD /C")) {
                command("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if (err) {
            throw new OsExecuteException("Errors executing " + command);
        }
    }

    public static void main(String[] args) throws IOException {
        String command = "cat ./src/se/io/Directory.java";
        OsExecute osExecute = new OsExecute();
        Map<String, List<String>> result = osExecute.executeCommand(command);
        result.forEach((key, values) -> {
            System.out.println("the " + command + key);
            values.forEach(System.out::println);
        });
    }
}
