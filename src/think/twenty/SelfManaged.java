package think.twenty;

public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "). ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }
}
