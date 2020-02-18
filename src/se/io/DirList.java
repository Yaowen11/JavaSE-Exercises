package se.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author zhangyaowen
 */
public class DirList {

    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File(".");
        System.out.println("absolute path is : " + path.getAbsolutePath());
        System.out.println("path is : " + path.getPath());
        File file = new File("Data.txt");
        System.out.println("absolute file" + file.getAbsoluteFile());
        System.out.println("absolute path" + file.getAbsolutePath());
        String[] list = args.length == 0 ? path.list() : path.list(filter(args[0]));
        if (list != null) {
            Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
            for (String dirItem : list) {
                System.out.println(dirItem);
            }
        }
    }

}
