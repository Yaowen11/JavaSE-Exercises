package think.eleven;

import java.util.*;

/**
 * @author z
 * @date 2020/5/28 17:44
 */
public class Fruits {
    public static void main(String[] args) {
        Collection<Fruit> fruits = new LinkedList<>();
        Set<Integer> index = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            index.add(i);
            fruits.add(FruitFunc.fruitFactory.getFruit());
        }
        fruits.forEach(fruit -> { System.out.println(fruit.taste());});
        index.forEach(System.out::println);
        addGroups();
    }

    public static void addGroups() {
        Collection<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Integer[] moreInts = { 6, 7, 8, 9, 10};
        integers.addAll(Arrays.asList(moreInts));
        Collections.addAll(integers, 1,2,3,100);
        integers.forEach(System.out::print);
    }
}
