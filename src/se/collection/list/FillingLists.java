package se.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangyaowen
 */
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("test")));
        System.out.println(list);
        Collections.fill(list, new StringAddress("world"));
        System.out.println(list);
    }
}
