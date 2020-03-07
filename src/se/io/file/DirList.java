package se.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author zhangyaowen
 */
public class DirList {

    public FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public String[] listDir(String dir, FilenameFilter filenameFilter) {
        File path = new File(dir);
        return path.list(filenameFilter);
    }

    public void dump(String dir, String regex) {
        String[] dirList = listDir(dir, filter(regex));
        if (dirList != null) {
            Arrays.sort(dirList, String.CASE_INSENSITIVE_ORDER);
            for (String dirItem : dirList) {
                System.out.println(dirItem);
            }
        }
    }

    public static void main(String[] args) {
        new DirList().dump(".", ".+out");
    }

}
