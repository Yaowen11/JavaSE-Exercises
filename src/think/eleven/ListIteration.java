package think.eleven;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zyw
 * @date 2020/5/29 21:31
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>(Fruits.fruits());
        ListIterator<Fruit> listIterator = fruitList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next().getClass().getSimpleName() + " ");
        }
        System.out.println();
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous().getClass().getSimpleName() + " ");
        }
    }
}
