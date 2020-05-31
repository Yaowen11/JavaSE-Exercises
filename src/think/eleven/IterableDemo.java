package think.eleven;

import java.util.Iterator;

/**
 * @author zyw
 * @date 2020/5/31 21:41
 */
public class IterableDemo<E> {

    private E[] es;
    
    IterableDemo(E[] es) {
        this.es = es;
    }

    private class It implements Iterable<E> {
        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
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
    }
}
