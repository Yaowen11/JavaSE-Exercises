package think.eleven;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author zyw
 * @date 2020/5/31 21:18
 */
public class CollectionSequence<E> extends AbstractCollection<E> {

    private final E[] es;

    CollectionSequence(E[] es) {
        this.es = es;
    }

    @Override
    public int size() {
        return es.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index == es.length;
            }
            @Override
            public E next() {
                return es[index++];
            }
        };
    }

    public static void main(String[] args) {
        CollectionSequence<Fruit> collectionSequence = new CollectionSequence<>(Fruits.fruits().toArray(Fruit[]::new));
        System.out.println(Arrays.toString(collectionSequence.es));
        InterfaceVsIterator.display(collectionSequence);
        Iterator<Fruit> iterator = collectionSequence.iterator();
        InterfaceVsIterator.display(iterator);
        while (!iterator.hasNext()) {
            System.out.println(iterator.next().getClass().getSimpleName() + " ");
        }
        System.out.println();
        for (Fruit fruit: collectionSequence) {
            System.out.println(fruit.getClass().getSimpleName() + " ");
        }
    }
}
