package think.eleven;

import think.Constant;

import java.util.*;

/**
 * @author zyw
 * @date 2020/5/29 20:42
 */
public class SimpleIteration {
    public static void main(String[] args) {
        display();
    }
    public static void iteration() {
        List<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < Constant.TEN; i++) {
            fruits.add(FruitFunc.fruitFactory.next());
        }
        Iterator<Fruit> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (System.currentTimeMillis() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println();
        fruits.forEach(System.out::println);
    }

    public static void display() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(FruitFunc.fruitFactory.next());
        LinkedList<Fruit> fruits1 = new LinkedList<>();
        fruits1.add(FruitFunc.fruitFactory.next());
        HashSet<Fruit> hashSet = new HashSet<>();
        hashSet.add(FruitFunc.fruitFactory.next());
        TreeSet<Fruit> treeSet = new TreeSet<>();
        treeSet.add(FruitFunc.fruitFactory.next());
        dump(fruits.iterator());
        dump(fruits1.iterator());
        dump(hashSet.iterator());
        dump(treeSet.iterator());
    }

    private static void dump(Iterator<Fruit> fruitIterator) {
        while (fruitIterator.hasNext()) {
            Fruit fruit = fruitIterator.next();
            System.out.println(fruit.getClass().getSimpleName());
        }
        System.out.println();
    }
}
