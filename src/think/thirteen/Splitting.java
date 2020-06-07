package think.thirteen;

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
    }
}
