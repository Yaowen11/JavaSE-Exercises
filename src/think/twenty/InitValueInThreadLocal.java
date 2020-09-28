package think.twenty;

import java.util.concurrent.TimeUnit;

public class InitValueInThreadLocal {
    private static final StringBuilder INIT_VALUE = new StringBuilder("init");
    private static final ThreadLocal<StringBuilder> builder = ThreadLocal.withInitial(() -> INIT_VALUE);
    private static class AppendStringThread extends Thread {
        @Override
        public void run() {
            StringBuilder stringBuilder = builder.get();
            for (int i = 0; i < 3; i++) {
                stringBuilder.append("-").append(i);
            }
            System.out.println(stringBuilder.toString());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ; i < 3; i++) {
            new AppendStringThread().start();
        }
        System.out.println("builder" + builder.get().toString());
        TimeUnit.SECONDS.sleep(10);
    }
}
