package se.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
/**
 * @author zhangyaowen
 */
public class CallableDemo {
    private static final int init = 10;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
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
