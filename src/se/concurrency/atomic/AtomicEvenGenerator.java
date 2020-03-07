package se.concurrency.atomic;

import se.concurrency.EvenChecker;
import se.concurrency.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyaowen
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);
    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
