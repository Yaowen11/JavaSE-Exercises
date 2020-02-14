package se.collection;

import java.util.*;

/**
 * @author zhangyaowen
 */
public class ListCurd<T> {

    T[] array;

    Collection<T> collection;
    ListCurd(T[] array) {
        this.array = array;
        collection = Arrays.asList(array);
    }

    void linkedListCurd(T node) {
        LinkedList<T> list = new LinkedList<>(collection);
        dump(list);
        iterator(list);
        System.out.println("insert node " + list.add(node));
        dump(list);
        System.out.println("delete node " + list.remove(node));
        dump(list);
    }

    void arrayListCurd(T node) {
        ArrayList<T> list = new ArrayList<>(collection);
        dump(list);
        iterator(list);
        System.out.println("insert node " + list.add(node));
        dump(list);
        System.out.println("delete node " + list.remove(node));
        dump(list);
    }

    private void iterator(List<T> list) {
        System.out.println(baseInfo(list) + Thread.currentThread().getStackTrace()[1].getMethodName() + ": ");
        for(T t: list) {
            System.out.print(t.toString() + " ");
        }
        System.out.println();
    }

    private void dump(List<T> list) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName() + ": ";
        System.out.println(baseInfo(list) + methodName +  list);
    }

    private String baseInfo(List<T> list) {
        return list.getClass().getSimpleName() + ": ";
    }

    public static void main(String[] args) {
        String[] init = "So this vector field is not conservative".split(" ");
        ListCurd<String> listCurd = new ListCurd<>(init);
        String node = "zyw";
        listCurd.linkedListCurd(node);
        listCurd.arrayListCurd(node);
    }
}
