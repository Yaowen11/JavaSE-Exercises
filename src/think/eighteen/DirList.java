package think.eighteen;

import se.io.file.Directory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Arrays;
import java.util.Set;

/**
 * @author z
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        var tem = path.toPath();
        DirList dirList = new DirList(path);
        Long size = dirList.fileSize((dir, name) -> name.contains(".jpg"));
        System.out.printf("jpg size: %d\n", size);
        String con = ".md";
        String[] containsJava = dirList.filter((dir, name) -> {
            try {
                if (name.contains(con)) {
                    String fileString = new String(new FileInputStream(name).readAllBytes());
                    System.out.printf("name: %s dir path %s File String: %s\n", name, dir.getAbsolutePath(), fileString);
                    return fileString.contains("Java");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        });
        System.out.println(Arrays.toString(containsJava));
        dirList.filePermission();
    }

    private final File file;

    public DirList(File file) {
        this.file = file;
    }

    public String[] filter(FilenameFilter fileFilter) {
        return file.list(fileFilter);
    }

    public long fileSize(FilenameFilter filenameFilter) {
        String[] files = file.list(filenameFilter);
        if (files == null) {
            return 0;
        }
        System.out.println(Arrays.toString(files));
        long sum = 0;
        for (String file : files) {
            File temp = new File(file);
            sum += temp.isFile() ? temp.length() : 0;
        }
        return sum;
    }

    public void filePermission() {
        Path path = file.toPath();
        PosixFileAttributeView posixFileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        PosixFileAttributes attributes = null;
        try {
            attributes = posixFileAttributeView.readAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<PosixFilePermission> permissionSet = attributes.permissions();
        String group = attributes.group().getName();
        String owner = attributes.owner().getName();
        String rwxFormPermissions = PosixFilePermissions.toString(permissionSet);
        System.out.printf("group: %s, owner: %s, permission: %s\n", group, owner, rwxFormPermissions);
    }
}
