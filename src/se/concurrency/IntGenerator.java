package se.concurrency;

/**
 * @author zhangyaowen
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    /**
     * return next int
     * @return
     */
    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
