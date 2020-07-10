package think.eighteen;

import java.util.*;

public class MyMap<K, V> implements Map<K, V> {

    private Set<Entry<K,V>> entries = new HashSet<>();

    @Override
    public V put(K key, V value) {
        entries.add(new Entry<>() {
            @Override
            public K getKey() {
                return key;
            }

            @Override
            public V getValue() {
                return value;
            }

            @Override
            public V setValue(V value) {
                return value;
            }
        });
        return value;
    }

    @Override
    public V remove(Object key) {
        Iterator<Entry<K,V>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Entry<K, V> entry = entryIterator.next();
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                entryIterator.remove();
                return value;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry: m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean containsKey(Object key) {
        for (Map.Entry<K, V> entry : entrySet()) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry<K, V> entry : entrySet()) {
            if (entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (Map.Entry<K, V> entry : entries) {
            values.add(entry.getValue());
        }
        return values;
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entries;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> entry : entries) {
            keys.add(entry.getKey());
        }
        return keys;
    }

    @Override
    public V get(Object key) {
        for (Map.Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int size = 10000;
        Runnable runnable = () -> mapUseSecond(size, new HashMap<>());
        runnable.run();
        Runnable runnable1 = () -> mapUseSecond(size, new MyMap<>());
        runnable1.run();
    }

    private static void mapUseSecond(int size, Map<Integer, String> map) {
        final String value = new Date().toString();
        long hashStart = System.currentTimeMillis();
        for (int i = 0; i < size; ++i) {
            map.put(i, value + i);
        }
        int mapLength = map.size();
        String maxValue = map.get(size - 1);
        System.out.printf("map length: %s max value: %s\n", mapLength, maxValue);
        long hashEnd = System.currentTimeMillis();
        System.out.printf("put %d item to map %s use %d\n", size, map.getClass().getSimpleName(), (hashEnd - hashStart));
    }
}
