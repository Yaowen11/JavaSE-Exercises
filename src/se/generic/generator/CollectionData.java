package se.generic.generator;

import se.generic.generation.Generator;

import java.util.ArrayList;

/**
 * @author zhangyaowen
 * @param <T>
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(generator.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> generator, int quantity) {
        return new CollectionData<>(generator, quantity);
    }
}
