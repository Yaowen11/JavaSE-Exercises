package think.twenty;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        twoJoinDump();
    }

    static void twoJoinDump() throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println(System.nanoTime()));
        Thread thread1 = new Thread(() -> System.out.println(System.nanoTime()));
        thread.start();
        thread1.start();
//        thread.join();
//        thread1.join();
    }
}
