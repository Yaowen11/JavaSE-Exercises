package think.fifteen.genericinterface;

import java.util.Iterator;

/**
 * @author zyw
 * @date 2020/6/22 21:30
 */
public class JoinFibonacci implements Iterable<Integer> {

    private final Fibonacci fibonacci = new Fibonacci();

    private int n;

    public JoinFibonacci(int count) { n = count; };

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
                return fibonacci.next();
            }

        };
    }

    public static void main(String[] args) {
        for (int i : new JoinFibonacci(21)) {
            System.out.println(i);
        }
    }
}
