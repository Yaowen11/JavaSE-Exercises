package se.generic.generator;

import se.generic.generation.Generator;

import java.lang.reflect.Array;

/**
 * @author zhangyaowen
 */
public class Generated {
    public static <T> T[] array(T[] a, Generator<T> generator) {
        return new CollectionData<T>(generator, a.length).toArray(a);
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> generator, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<T>(generator, size).toArray(a);
    }
}
