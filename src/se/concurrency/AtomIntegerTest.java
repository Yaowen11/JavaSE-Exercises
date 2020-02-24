package se.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyaowen
 */
public class AtomIntegerTest implements Runnable {
    private AtomicInteger integer = new AtomicInteger(0);
    public int getValue() {
        return integer.get();
    }
    private void evenIncrement() {
        integer.addAndGet(2);
    }
    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomIntegerTest atomicIntegerTest = new AtomIntegerTest();
        executorService.execute(atomicIntegerTest);
        while (true) {
            int val = atomicIntegerTest.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
