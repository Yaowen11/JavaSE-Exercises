package think.seventeen;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author z
 **/
public class AssociativeArray<K, V> {

    private final Object[][] paris;

    private int index;

    public AssociativeArray(int length) {
        paris = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= paris.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        paris[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(paris[i][0])) {
                return (V) paris[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(paris[i][0].toString()).append(" : ").append(paris[i][1].toString());
            if (i < index - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int size = 6;
        AssociativeArray<String, String> map = new AssociativeArray<>(size);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("sky"));
    }
}
