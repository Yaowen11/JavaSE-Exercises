package think.twenty;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyaowen
 * @date 2020/9/22 10:59 下午
 **/
public class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting A daemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
//        t.setDaemon(true);
        t.start();
    }
}
