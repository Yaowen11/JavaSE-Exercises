package think.fifteen.genericinterface;

import java.util.Iterator;

/**
 * @author zyw
 * @date 2020/6/22 21:25
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int count) { n = count; }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(19)) {
            System.out.print(i + " ");
        }
    }
}
