package think.twenty;

public class VolatileDemo {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000;
    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();
        for (int i = 0; i < NUMBER; i++) {
            count++;
        }
        while (subtractThread.isAlive()){}
        System.out.println(count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                count--;
            }
        }
    }
}
