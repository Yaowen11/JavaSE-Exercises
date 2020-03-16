package se.collection.list;

import java.lang.reflect.Array;
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
        useList.arrayAsListThrowUnsupportedOperationException();
        useList.listToArray();
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
        System.out.println("源集合源数组");
        System.out.println("array: " + Arrays.toString(strings));
        System.out.println("list: " + stringList);
        strings[0] = "array 0";
        System.out.println("数组转集合后修改源数组值");
        System.out.println("array: " + Arrays.toString(strings));
        System.out.println("list: " + stringList);
        System.out.println("数组转集合后修改集合值");
        stringList.set(1, "list e");
        System.out.println("array: " + Arrays.toString(strings));
        System.out.println("list: " + stringList);
        stringList.set(0, "one list");
        // Throw UnsupportedOperationException
//        stringList.add(3, "three list");
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

    public void listToArray() {
        List<String> list = generateList(TYPE.ArrayList);
        String[] strings = list.toArray(new String[0]);
        System.out.println("集合转数组源");
        System.out.println("集合: " + list);
        System.out.println("数组: " + Arrays.toString(strings));
        list.set(1, "list e");
        System.out.println("集合转数组后修改源集合");
        System.out.println("集合: " + list);
        System.out.println("数组: " + Arrays.toString(strings));
        strings[0] = "array 0";
        System.out.println("集合转数组后修改数组");
        System.out.println("集合: " + list);
        System.out.println("数组: " + Arrays.toString(strings));
        System.out.println(list);
        System.out.println(Arrays.toString(strings));
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.toArray(new String[0]);
    }
}
