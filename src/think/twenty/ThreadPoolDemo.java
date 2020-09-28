package think.twenty;

import java.sql.Time;
import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        rejectDump();
    }

    public static void cachePoolDump() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        dump(executorService);
    }

    public static void threadPoolRecoverDump() {
        var threadPool = new ThreadPoolExecutor(
                6,
                12,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                r -> new Thread(r, "user-")
        );
        System.out.println(threadPool.allowsCoreThreadTimeOut());
        threadPool.allowCoreThreadTimeOut(true);
        dump(threadPool);
    }

    public static void threadPoolNoRecoverDump() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                6,
                12,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                r -> new Thread(r, "user-")
        );
        dump(threadPool);
    }

    public static void rejectDump() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 2, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2), r -> new Thread(r, "custom"),
                (r, executor) -> System.out.println("task rejected " + executor.toString())
        );
        Runnable task = () -> System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 6; i++) {
            threadPoolExecutor.execute(task);
        }
    }

    public static void dump(ExecutorService executorService) {
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            executorService.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
    }
}
