package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangyaowen
 */
public interface Sort {

    static final int DEFAULT_SIZE = 10;

    static final int SORT_SIZE = 2;

    enum ORDER {
        /**
         * order in desc
         */
        DESC,
        /**
         * order in asc
         */
        ASC
    }

    /**
     * sort
     * @param origin origin array
     * @param order order
     * @param <T> generic
     */
    <T extends Comparable<T>>void sort(T[] origin, ORDER order);

    /**
     * generate Integer array
     * @return Integer[]
     */
    default Integer[] generateOriginIntegerArray() {
        Integer[] origin = new Integer[DEFAULT_SIZE];
        Random random = new Random();
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            origin[i] = random.nextInt(1000);
        }
        return origin;
    }

    /**
     * dump sort result
     */
    default void dump() {
        Integer[] origin = generateOriginIntegerArray();
        System.out.println("origin array: " + Arrays.toString(origin));
        sort(origin, ORDER.DESC);
        System.out.println(getClass().getSimpleName() + " descend sort: " + Arrays.toString(origin));
        sort(origin, ORDER.ASC);
        System.out.println(getClass().getSimpleName() + " asc sort: " + Arrays.toString(origin));
    }

}
