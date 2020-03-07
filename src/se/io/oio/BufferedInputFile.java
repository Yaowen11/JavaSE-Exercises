package se.io.oio;

import java.io.*;
import java.util.*;

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
        String file = "worm.out";
        BufferedInputFile bufferedInputFile = new BufferedInputFile();
        Map<Integer, String> lineMap = bufferedInputFile.readFileLineNumberMapContentUseInputStream(file);
        lineMap.forEach((Integer number, String content)->{
            System.out.println("line number: " + number + " content " + content);
        });
        lineMap = bufferedInputFile.readFileLineNumberMapContentUseReader(file);
        lineMap.forEach((integer, s) -> {
            System.out.println("line number: " + integer + " content " + s);
        });
    }

    /**
     * 使用 inputStream 读取一行，读取 byte 转 string
     * @param file file name
     * @return map line number map single string
     * @throws IOException read exception
     */
    public Map<Integer, String> readFileLineNumberMapContentUseInputStream(String file) throws IOException {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            Map<Integer, String> lineMapString = new HashMap<>();
            int readByte;
            int lineNumber = 0;
            List<Integer> lineByte = new ArrayList<>();
            while ((readByte = inputStream.read()) != -1) {
                if (readByte == 10) {
                    lineNumber++;
                    byte[] bytes = new byte[lineByte.size()];
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] = lineByte.get(i).byteValue();
                    }
                    lineMapString.put(lineNumber, new String(bytes));
                    lineByte.clear();
                } else {
                    lineByte.add(readByte);
                }
            }
            return lineMapString;
        }
    }

    /**
     * 使用 reader 读取一行，直接读取一行
     * @param file file
     * @return Map line number map string
     * @throws IOException read exception
     */
    public Map<Integer, String> readFileLineNumberMapContentUseReader(String file) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Map<Integer, String> lineNumberMapContent = new HashMap<>();
            int i = 0;
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                i++;
                lineNumberMapContent.put(i, temp);
            }
            return lineNumberMapContent;
        }
    }

}
