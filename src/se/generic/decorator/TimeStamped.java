package se.generic.decorator;

/**
 * @author zhangyaowen
 */
class TimeStamped extends Decorator {

    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        timeStamp = System.currentTimeMillis();
    }

    public long getStamp() {
        return timeStamp;
    }

}
