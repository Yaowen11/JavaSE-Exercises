package se.concurrency.thread;


/**
 * @author zhangyaowen
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleeper);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}
