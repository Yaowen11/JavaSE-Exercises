package se.generic.generation;

/**
 * @author zhangyaowen
 */
public class Fibonacci implements Generator<Long> {

    private int count = 0;

    @Override
    public Long next() {
        return fib(count++);
    }

    private long fib(int n) {
        int ignore = 2;
        if (n < ignore) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }
}
