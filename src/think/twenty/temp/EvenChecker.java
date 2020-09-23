package think.twenty.temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(generator, i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}
