package think.eleven;

import java.util.*;

/**
 * @author zyw
 * @date 2020/5/31 21:07
 */
public class InterfaceVsIterator {
    public static void display(Iterator<Fruit> iterator) {
        while (iterator.hasNext()) {
            Fruit fruit = iterator.next();
            System.out.print(fruit.getClass().getSimpleName() + " ");
        }
        System.out.println();
    }
    public static void display(Collection<Fruit> collection) {
        for (Fruit fruit: collection) {
            System.out.print(fruit.getClass().getSimpleName() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Collection<Fruit> fruits = Fruits.fruits();
        List<Fruit> fruitList = new ArrayList<>(fruits);
        Set<Fruit> fruitSet = new HashSet<>(fruitList);
        Map<String, Fruit> stringFruitMap = new LinkedHashMap<>();
        String[] names = "Ralph, Eric, Robin, Lacey, Britney, Sam, Spot, Fluffy".split(", ");
        for (int i = 0; i < names.length; i++) {
            stringFruitMap.put(names[i], fruitList.get(i));
        }
        display(fruitList);
        display(fruitSet);
        display(fruitList.iterator());
        display(fruitSet.iterator());
        display(stringFruitMap.values());
        display(stringFruitMap.values().iterator());
    }
}
