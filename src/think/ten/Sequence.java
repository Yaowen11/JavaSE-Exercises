package think.ten;

import java.util.Date;

/**
 * @author zyw
 * @date 2020/5/25 20:51
 */
public class Sequence {

    private final Object[] items;

    private int next = 0;

    public Sequence(int size) { items = new Object[size]; }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        Sequence sequence() {
            return Sequence.this;
        }
    }

    private class ReverseSelector implements Selector {
        private int i = items.length - 1;
        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int size = 10;
        Sequence sequence = new Sequence(size);
        for (int i = 0; i < size; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        Selector reverse = sequence.new ReverseSelector();
        System.out.println(new Date());
        System.out.println(reverse.end());
        while (!reverse.end()) {
            System.out.print(reverse.current() + " ");
            reverse.next();
        }
    }
}

interface Selector {
    boolean end();
    Object current();
    void next();
}

