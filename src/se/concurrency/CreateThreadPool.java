package se.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @author zhangyaowen
 */
public class CreateThreadPool {

    public ExecutorService generate() {
        return new ScheduledThreadPoolExecutor(1,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread();
                    }
                });
    }
}
