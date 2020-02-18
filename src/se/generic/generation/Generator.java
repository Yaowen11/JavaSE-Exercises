package se.generic.generation;

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

