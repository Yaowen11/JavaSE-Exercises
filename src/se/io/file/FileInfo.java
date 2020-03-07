package se.io.file;

import java.io.File;

/**
 * @author zhangyaowen
 */
public class FileInfo {

    public static void fileInfo(File file) {
        if (file == null) {
            return;
        }
        String type = file.isFile() ? "file" : "dir";
        System.out.printf("type %s get name %s\n", type, file.getName());
        System.out.printf("type %s get path %s\n", type, file.getPath());
        System.out.printf("type %s get abs file %s\n", type, file.getAbsoluteFile());
        System.out.printf("type %s get abs path %s\n", type, file.getAbsolutePath());
        System.out.printf("type %s length %d byte\n", type, file.length());
    }

    public static void main(String[] args) {
        fileInfo(new File("./src/dir.json"));
    }
}
