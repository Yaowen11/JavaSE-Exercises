package se.generic.generator;

import se.generic.generation.Generator;

import java.util.LinkedHashMap;

/**
 * map generate
 * @author zhangyaowen
 * @param <K>
 * @param <V>
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    public MapData(Generator<Pair<K, V>> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = generator.next();
            put(p.key, p.value);
        }
    }

    public MapData(Generator<K> kGenerator, Generator<V> vGenerator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(kGenerator.next(), vGenerator.next());
        }
    }

    public MapData(Generator<K> kGenerator, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(kGenerator.next(), value);
        }
    }

    public MapData(Iterable<K> genK, Generator<V> generator) {
        for (K key: genK) {
            put(key, generator.next());
        }
    }

    public MapData(Iterable<K> genK, V value) {
        for (K key: genK) {
            put(key, value);
        }
    }

    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> generator, int quantity) {
        return new MapData<>(generator, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> kGenerator, Generator<V> vGenerator, int quantity) {
        return new MapData<>(kGenerator, vGenerator, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> kGenerator, V value, int quantity) {
        return new MapData<>(kGenerator, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> gen, Generator<V> vGenerator) {
        return new MapData<>(gen, vGenerator);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> gen, V value) {
        return new MapData<>(gen, value);
    }
}
