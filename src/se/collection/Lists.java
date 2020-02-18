package se.collection;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zhangyaowen
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> lt;
    private static ListIterator<String> lit;
    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();

    }
}
