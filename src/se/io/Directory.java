package se.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author zhangyaowen
 */
public final class Directory {

    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {

        public List<File> files = new ArrayList<>();

        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            StringBuilder json = new StringBuilder("{\"path\":");
            json.append("\"").append(files.get(0).getAbsolutePath()).append("\",\"files\":[");
            for (File file: files) {
                json.append("\"").append(file.getName()).append("\",");
            }
            json.setCharAt(json.length() - 1, ']');
            json.append(",\"dirs\":[");
            for (File dir: dirs) {
                json.append("\"").append(dir.getName()).append("\",");
            }
            json.setCharAt(json.length() - 1, ']');
            json.append("}");
            return json.toString();
        }
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        File[] files = startDir.listFiles();
        if (files != null) {
            for (File item : files) {
                if (item.isDirectory()) {
                    result.dirs.add(item);
                    result.addAll(recurseDirs(item, regex));
                } else {
                    if (item.getName().matches(regex)) {
                        result.files.add(item);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else {
            for (String arg : args) {
                System.out.println(walk(arg));
            }
        }
    }
}
