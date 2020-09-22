package think.twenty;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyaowen
 * @date 2020/9/22 10:26 下午
 **/
public class DaemonsDemo implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DaemonsDemo());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
