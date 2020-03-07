package se.concurrency.executors;

import se.concurrency.thread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangyaowen
 */
public class ExecutorUse {

    private static final int init = 5;

    public static void main(String[] args) {
        ExecutorUse executorUse = new ExecutorUse();
        executorUse.fixedThreadPool();
    }

    private void cacheThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < init; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

    private void fixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(init);
        for (int i = 0; i < init; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

    private void singleThreadPool() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < init; i++) {
            singleThreadPool.execute(new LiftOff());
        }
        singleThreadPool.shutdown();
    }
}
