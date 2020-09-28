package think.twenty;

import java.util.concurrent.*;

public class ThreadThrowDemo {

    public static void main(String[] args) throws Exception{
        runThrowInMainByPool();
        ExecutorService executorService = Executors.newWorkStealingPool();
        var s = Executors.newScheduledThreadPool(2);
    }

    public static void callThrowInMainThreadDump() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<String> callable = () -> {
            if (System.currentTimeMillis() % 3 == 0) {
                return String.valueOf(3);
            }
            throw new NullPointerException("throw null exception");
        };
        Future<String> future = executorService.submit(callable);
        System.out.println(future.get());
    }

    public static void runThrowInThreadDump() {
        new Thread(ThreadThrowDemo.runnable()).start();
    }

    public static void runThrowInMainThread() {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            if (e instanceof NullPointerException) {
                System.out.println("catch null exception");
            }
        });
        new Thread(ThreadThrowDemo.runnable()).start();
    }

    public static void runThrowInMainByPool() {
        ExecutorService executorService = Executors.newCachedThreadPool(r -> {
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler((t, e) -> {
                if (e instanceof NullPointerException) {
                    System.out.println("catch null exception");
                }
            });
            return thread;
        });
        executorService.execute(ThreadThrowDemo.runnable());
    }

    public static Runnable runnable() {
        return () -> {
            if (System.currentTimeMillis() % 9 == 0) {
                System.out.println(7);
            }
            throw new NullPointerException("throw null exception in main thread");
        };
    }

    public static void runDemo() {
        Thread thread = new Thread(ThreadThrowDemo.runnable());
        thread.interrupt();
    }
}
