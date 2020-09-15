package base;

import java.lang.ref.Cleaner;

public class CleaningExample implements AutoCloseable {
    // cleaner 实现
    private static final Cleaner cleaner = Cleaner.create();
    static class State implements Runnable {
        @Override
        public void run() {
            // 清理逻辑，最多执行一次
        }
    }
    private final Cleaner.Cleanable cleanable;
    private final State state;
    public CleaningExample() {
        this.state = new State();
        this.cleanable = cleaner.register(this, state);
    }
    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
