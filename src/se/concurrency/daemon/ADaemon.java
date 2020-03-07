package se.concurrency.daemon;

import java.util.concurrent.TimeUnit;

/**
 * @author z
 */
class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Start ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via Interruption exception");
        } finally {
            System.out.println("This is finally statement");
        }
    }
}
