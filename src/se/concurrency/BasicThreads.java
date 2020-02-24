package se.concurrency;

/**
 * @author zhangyaowen
 */
public class BasicThreads {

    public static void main(String[] args) {
        moreThread();
    }

    public static void basicThread() {
        System.out.println("basic thread");
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff");
    }

    public static void moreThread() {
        System.out.println("more thread");
        int max = 5;
        for (int i = 0; i < max; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("more thread run");
    }
}
