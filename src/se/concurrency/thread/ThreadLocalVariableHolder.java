package se.concurrency.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyaowen
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<>() {
        private Random random = new Random(47);
        @Override
        protected synchronized Integer initialValue() {
            return random.nextInt();
        }
    };
    public static void increment() {
        value.set(value.get() + 1);
    }
    public static int get() {
        return value.get();
    }
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int end = 5;
        for (int i = 0; i < end; i++) {
            executorService.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        executorService.shutdown();
    }
}
