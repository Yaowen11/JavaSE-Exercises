package se.concurrency.factory;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author z
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "From UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        return new Thread(null, task, name, 0, false);
    }

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(6, 12, 60, TimeUnit.SECONDS,
                        new LinkedTransferQueue<>(), new UserThreadFactory("mine"));
        for (int i = 0; i < 5; i++) {
            executor.execute(() ->
                    System.out.println("THREAD NAME :" + Thread.currentThread().getName() + " ID: " + Thread.currentThread().getId()));
        }
        executor.shutdown();
    }
}
