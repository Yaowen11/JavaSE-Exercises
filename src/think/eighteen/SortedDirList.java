package think.eighteen;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author z
 */
public class SortedDirList {
    private final File file;
    public SortedDirList(File file) { this.file = file; }
    public String[] list() {
        String[] strings = file.list();
        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
        return strings;
    }
    public String[] list(final String regex) {
        String[] strings = file.list(new FilenameFilter() {
            private final Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
        return strings;
    }
    public long size(String file) {
        File file1 = new File(file);
        return file1.length();
    }

    public static void main(String[] args) {
        SortedDirList sortedDirList = new SortedDirList(new File("."));
        String file = "preferences_tree.xml";
        System.out.printf("file %s size of %d\n", file, sortedDirList.size(file));
    }
}
