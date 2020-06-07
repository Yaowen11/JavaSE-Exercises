package think.eleven;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyw
 * @date 2020/6/1 20:56
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<Fruit> collection = Fruits.fruits();
        List<Fruit> list = new LinkedList<>(Fruits.fruits());


    }
}
