package think.twenty;

/**
 * @author zhangyaowen
 * @date 2020/9/22 8:28 下午
 **/
public class LiftOff implements Runnable {

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
        Runnable runnable = new LiftOff();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("call back");
    }

    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "). ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
