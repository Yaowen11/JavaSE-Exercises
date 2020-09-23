package think.twenty.temp;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTestDemo implements Runnable {
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
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTestDemo atomicIntegerTestDemo = new AtomicIntegerTestDemo();
        executorService.execute(atomicIntegerTestDemo);
        while (true) {
            int val = atomicIntegerTestDemo.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
