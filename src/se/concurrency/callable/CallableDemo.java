package se.concurrency.callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhangyaowen
 */
public class CallableDemo {
    private static final int init = 10;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
        Future<String> future1 = executorService.submit(new TaskWithResult(100));
        try {
            System.out.println(future1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < init; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> future: futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally{
                executorService.shutdown();
            }
        }
    }
}
