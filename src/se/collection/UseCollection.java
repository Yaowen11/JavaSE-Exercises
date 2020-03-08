package se.collection;

import se.collection.list.UseList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author z
 */
public class UseCollection {

    public static void main(String[] args) {
        UseCollection useCollection = new UseCollection();
        useCollection.addAllFunc();
    }

    public void immutableList() {
        List<String> list = Collections.emptyList();
        // throws UnsupportedOperationException
        list.add("hello");
    }

    public void addAllFunc() {
        Collection<String> stringCollection = UseList.generateList(UseList.TYPE.ArrayList);
        Collection<String> arrayList = new ArrayList<>();
        // throw NullPointerException
        arrayList.addAll(null);
        System.out.println(arrayList);
        System.out.println();
    }
}
