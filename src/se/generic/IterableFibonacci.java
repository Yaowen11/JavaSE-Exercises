package se.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhangyaowen
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Long> {

    private HashMap<Integer, Long> sum;

    private Integer length;

    public IterableFibonacci(int length) {
        this.length = length;
        this.sum = new HashMap<>(length);
        for (int n = length; n >  0; n--) {
            this.sum.put(n, 0L);
        }
    }

    public Integer getLength() {
        return length;
    }

    public void dumpSum() {
        for (Map.Entry<Integer, Long> entry : sum.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }

    @Override
    public Iterator<Long> iterator() {

        return new Iterator<Long>() {

            @Override
            public boolean hasNext() {
                return length > 0;
            }

            @Override
            public Long next() {
                long current = sum.get(length);
                if (current == 0L) {
                    current = IterableFibonacci.this.next();
                    sum.put(length, current);
                }
                length--;
                return current;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        try {
            int integer = Integer.parseInt(args[0]);
            IterableFibonacci fibonacci = new IterableFibonacci(integer);
            for (Long aLong : fibonacci) {
                System.out.println(aLong);
            }
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
