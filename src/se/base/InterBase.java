package se.base;

/**
 * @author zhangyaowen
 */
public interface InterBase<T> extends Comparable<T>{
    /**
     * no default
     * @return
     */
    int changeSale();

    /**
     * 始终大于
     * @param o
     * @return
     */
    @Override
    default int compareTo(T o) {
        if (o.getClass() == getClass()) {
            return 0;
        }
        return 1;
    }
}
