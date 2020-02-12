package se.generic.decorator;

/**
 * @author zhangyaowen
 */
public class Decoration {

    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t1 = new TimeStamped(new SerialNumbered(new Basic()));
        SerialNumbered s = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
    }
}
