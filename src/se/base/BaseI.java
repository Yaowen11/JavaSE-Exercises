package se.base;

/**
 * @author zhangyaowen
 */
public interface BaseI {
    /**
     * default
     * @return
     */
    default int changSale() {
        return 1;
    }
}
