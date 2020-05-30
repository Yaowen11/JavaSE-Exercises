package think.eleven;

import think.Constant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author z
 * @date 2020/5/28 16:51
 */
public class Apples {
    public static void main(String[] args) {
        dumpContainer();
    }

    public static void dump() {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.forEach(apple -> {System.out.println(apple.getId());});
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fruits.add(FruitFunc.fruitFactory.getFruit());
        }
        fruits.forEach(
                fruit ->
                {if (fruit instanceof Apple) {
                    System.out.println(((Apple) fruit).getId());
                } else {
                    System.out.println(fruit.getClass().getSimpleName() + fruit.getClass());
                }
                });
    }

    public static void dumpContainer() {
        Fruit[] fruits = new Fruit[Constant.THREE];
        List<Fruit> arrayList = new ArrayList<>();
        List<Fruit> linkedList = new LinkedList<>();
        Set<Fruit> hashSet = new HashSet<>();
        Set<Fruit> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Fruit> treeSet = new TreeSet<>();
        for (int i = 0; i < Constant.THREE; i++) {
            fruits[i] = FruitFunc.fruitFactory.next();
            arrayList.add(FruitFunc.fruitFactory.next());
            linkedList.add(FruitFunc.fruitFactory.next());
            hashSet.add(FruitFunc.fruitFactory.next());
            linkedHashSet.add(FruitFunc.fruitFactory.next());
            treeSet.add(FruitFunc.fruitFactory.next());
        }
        System.out.println("array dump");
        for (Fruit fruit: fruits) {
            System.out.println(fruit.getClass().getSimpleName());
        }
        System.out.println();
        System.out.println("Array list dump:");
        arrayList.forEach(fruit -> {System.out.print(fruit.getClass().getSimpleName() + " ");});
        System.out.println();
        System.out.println("linked list dump:");
        linkedList.forEach(fruit -> {System.out.print(fruit.getClass().getSimpleName() + " ");});
        System.out.println();
        System.out.println("linked hash set dump:");
        linkedHashSet.forEach(fruit -> {System.out.print(fruit.getClass().getSimpleName() + " ");});
        System.out.println();
        System.out.println("tree set dump:");
        treeSet.forEach(fruit -> {System.out.print(fruit.getClass().getSimpleName() + " ");});
        System.out.println();
        System.out.println("hash set dump:");
        hashSet.forEach(fruit -> {System.out.print(fruit.getClass().getSimpleName() + " ");});
        hashSet.add(new Apple());
        hashSet.add(new Apple());
        hashSet.forEach(fruit -> {System.out.println(fruit.getClass().getSimpleName());});
    }
}
