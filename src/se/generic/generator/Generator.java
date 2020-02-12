package se.generic.generator;

/**
 * @author zhangyaowen
 */
public interface Generator<T> {
    /**
     * generate T
     * @return T
     */
    T next();
}

