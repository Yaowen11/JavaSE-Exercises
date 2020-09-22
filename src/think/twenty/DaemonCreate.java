package think.twenty;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyaowen
 * @date 2020/9/22 10:52 下午
 **/
public class DaemonCreate {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ". ");
        TimeUnit.SECONDS.sleep(1);
    }
}

class Daemon implements Runnable {
    private Thread[] t = new Thread[6];
    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ". ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override public void run() {
        while (true) {
            Thread.yield();
        }
    }
}