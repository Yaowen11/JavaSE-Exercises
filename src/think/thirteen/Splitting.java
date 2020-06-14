package think.thirteen;

import java.text.DateFormat;
import java.util.Arrays;

/**
 * @author zyw
 * @date 2020/6/7 21:46
 */
public class Splitting {
    public static String Knights = "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";
    public static void split(String regex) {
        System.out.println(Arrays.toString(Knights.split(regex)));
    }
    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
        id("511381199112158176");
        replace();
    }

    public static void id(String id) {
        String birthday = id.substring(6, 14);
        System.out.println(birthday);
    }

    public static void replace() {
        System.out.println(Knights.replaceFirst("f\\w+", "located"));
        System.out.println(Knights.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
