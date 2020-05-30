package think.eleven;

import java.util.LinkedList;

/**
 * @author zyw
 * @date 2020/5/30 13:24
 */
public class LinkedListFeatures {
    public static void dump() {
        LinkedList<Fruit> fruits = new LinkedList<>(Fruits.fruits());
        System.out.println(fruits);
        System.out.println("first: " + fruits.getFirst());
        System.out.println("element: " + fruits.element());
        System.out.println("peek: " + fruits.peek());
        System.out.println("remove: " + fruits.remove());
        System.out.println("removeFirst(): " + fruits.removeFirst());
        System.out.println(fruits);
    }
    public static void main(String[] args) {
        dump();
    }
}
