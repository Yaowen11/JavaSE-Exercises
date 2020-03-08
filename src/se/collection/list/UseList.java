package se.collection.list;

import java.util.*;

/**
 * @author zhangyaowen
 */
public class UseList {

    public enum TYPE {
        /**
         * arrayList
         */
        ArrayList,
        /**
         * Linked
         */
        Linked,
    }

    public static void main(String[] args) {
        UseList useList = new UseList();
        useList.castArray();
    }

    public void castArray() {
        List<String> list = generateList(TYPE.Linked);
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
    public void arrayAsListThrowUnsupportedOperationException() {
        String[] strings = new String[3];
        strings[0] = "one";
        strings[1] = "two";
        strings[2] = "three";
        List<String> stringList = Arrays.asList(strings);
        stringList.set(0, "one list");
        // Throw UnsupportedOperationException
        stringList.add(3, "three list");
    }

    public void arrayListSublist() {
        LinkedList<String> strings = (LinkedList<String>) generateList(TYPE.Linked);
        System.out.println(strings);
        List<String> subList = strings.subList(0, 2);
        System.out.println(subList);
        subList.set(1, "sublist add");
        System.out.println(strings);
        // throws ConcurrentModificationException
        strings.add("origin add");
        System.out.println(strings);
        System.out.println(subList);
    }

    public static List<String> generateList(TYPE type) {
        int end = 5;
        List<String> list;
        switch (type) {
            case ArrayList:
                list = new ArrayList<>();
                break;
            case Linked:
                list = new LinkedList<>();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        for (int i = 0; i < end; i++) {
            list.add("String " + i);
        }
        return list;
    }
}
