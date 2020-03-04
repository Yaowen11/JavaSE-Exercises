package se.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyaowen
 */
public class ArrayAsList {
    public static void main(String[] args) {
        ArrayAsList asList = new ArrayAsList();
        asList.arrayAsList();
    }
    public void arrayAsList() {
        String[] strings = new String[3];
        strings[0] = "one";
        strings[1] = "two";
        strings[2] = "three";
        List<String> stringList = Arrays.asList(strings);
        stringList.set(0, "one list");
        stringList.add(3, "three list");
    }
}
