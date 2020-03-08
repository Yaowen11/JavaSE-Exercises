package se.base;

import java.util.Arrays;
import java.util.List;

/**
 * @author z
 */
public class UseArray {

    public static void main(String[] args) {
        UseArray useArray = new UseArray();
        useArray.asToList();
    }

    public void asToList() {
        String[] strings = generate();
        List<String> list = Arrays.asList(strings);
        // throw UnsupportedOperationException
        list.add("list add element");
    }

    public <T> void generic(T[] t) {
        String[] strings = new String[3];

    }
    public static String[] generate() {
        int length = 5;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = "String " + i;
        }
        return strings;
    }
}
