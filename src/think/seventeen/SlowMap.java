package think.seventeen;

import kotlin.collections.AbstractMap;

import java.util.*;

/**
 * @author z
 **/
public class SlowMap<K, V> extends AbstractMap<K, V> {

    private final List<K> keys = new ArrayList<>();

    private final List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    private Set<Map.Entry<K, V>> get() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> kIterator = keys.iterator();
        Iterator<V> vIterator = values.iterator();
        while (kIterator.hasNext()) {
            set.add(new MapEntry<>(kIterator.next(), vIterator.next()));
        }
        return set;
    }

    @Override
    public Set<Map.Entry<K, V>> getEntries() {
        return get();
    }

    @Override
    public int getSize() {
        return keys.size();
    }

    public static void main(String[] args) {
        SlowMap<String, String> map = new SlowMap<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        System.out.println(map);
        System.out.println(map.entrySet());
    }
}
