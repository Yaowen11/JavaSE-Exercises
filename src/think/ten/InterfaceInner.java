package think.ten;

import java.util.Iterator;

/**
 * @author z
 * @date 2020/5/27 15:25
 */
public class InterfaceInner {

    interface U {
        void first();

        void second();

        void third();
    }

    static class A1 {
        public U getU() {
            return new U() {
                @Override
                public void first() {
                    System.out.println("A1 first()");
                }

                @Override
                public void second() {
                    System.out.println("A1 second()");
                }

                @Override
                public void third() {
                    System.out.println("A1 third()");
                }
            };
        }
    }

    static class B2 {

        private final U[] us;

        private final int size;

        private int index = 0;

        public B2(int size) {
            this.size = size;
            us = new U[size];
        }

        public void add(U u) {
            if (index < size) {
                us[index++] = u;
            }
        }

        public void del(int i) {
            if (i < 0 || i >= size) {
                return;
            }
            us[i] = null;
        }

        public Iterator<U> loop() {
            return new Iterator<>() {
                private int index = 0;
                @Override
                public boolean hasNext() {
                    return index != us.length;
                }
                @Override
                public U next() {
                    return us[index++];
                }
            };
        }
    }

    public static void main(String[] args) {
        int size = 10;
        B2 b2 = new B2(size);
        for (int i = 0; i < size; i++) {
            b2.add(new A1().getU());
        }
        for (int i = 0; i < size; i++) {
            if (i%2 == 0) {
                b2.del(i);
            }
        }
        Iterator<U> uIterator = b2.loop();
        while (uIterator.hasNext()) {
            System.out.println(uIterator.next());
        }
    }
}
