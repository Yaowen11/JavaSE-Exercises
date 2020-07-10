package think.eighteen;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author z
 */
public class DirList {
    public static void main(String[] args) {
        String fileRegex = ".+\\..+";
        System.out.printf("args[0] = %s, %s == %s %b\n", args[0], args[0], fileRegex, fileRegex.equals(args[0]));
        File path = new File(".");
        String[] list = args.length == 0 ? path.list() :
                path.list(new FilenameFilter() {
                    private final Pattern pattern = Pattern.compile(args[0]);
                    @Override
                    public boolean accept(File dir, String name) {
                        return pattern.matcher(name).matches();
                    }
                });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(list.length);
        for (String file: Objects.requireNonNull(list)) {
            System.out.println(file);
        }
        String[] currents = path.list(filenameFilter(fileRegex));
        System.out.println("file:");
        for (String filePath: currents) {
            System.out.println(filePath);
        }
    }

    public static FilenameFilter filenameFilter(final String regex) {
        return new FilenameFilter() {
            private final Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
}
