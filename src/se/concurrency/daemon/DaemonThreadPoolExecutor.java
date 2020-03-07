package se.concurrency.daemon;

import se.concurrency.daemon.DaemonThreadFactory;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyaowen
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, 2, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new DaemonThreadFactory()
                );

    }
}
