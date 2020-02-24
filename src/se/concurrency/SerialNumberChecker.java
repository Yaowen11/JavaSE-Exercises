package se.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Circularset {
    private int[] array;
    private int len;
    private int index = 0;
    public Circularset(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }
    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }
    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}
/**
 * @author zhangyaowen
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static Circularset circularset = new Circularset(1000);
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (circularset.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                circularset.add(serial);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++) {
            if (args.length > 0) {
                TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
                System.out.println("No duplicates detected");
                System.exit(0);
            }
        }
    }
}
