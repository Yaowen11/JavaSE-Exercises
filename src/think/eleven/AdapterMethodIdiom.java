package think.eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author zyw
 * @date 2020/6/1 19:55
 */
public class AdapterMethodIdiom {
    static class ReversibleArrayList<T> extends ArrayList<T> {

        ReversibleArrayList(Collection<T> c) {
            super(c);
        }

        public Iterable<T> iterable() {
            return new Iterable<T>() {
                @Override
                public Iterator<T> iterator() {
                    return new Iterator<>() {
                        int current = size() - 1;
                        @Override
                        public boolean hasNext() {
                            return current > -1;
                        }

                        @Override
                        public T next() {
                            return get(current--);
                        }
                        @Override
                        public void remove() {
                            throw new UnsupportedOperationException();
                        }
                    };
                }
            };
        }

    }

    public static void main(String[] args) {
        ReversibleArrayList<String> reversibleArrayList = new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        for (String s: reversibleArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s: reversibleArrayList.iterable()) {
            System.out.print(s + " ");
        }
    }

}
