package think.seventeen;

import java.util.Arrays;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * @author z
 **/
public class WeakMap {
    public static void main(String[] args) {
        int size = 9;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> weakHashMap = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = k;
            }
            weakHashMap.put(k, v);
        }
        System.out.println(weakHashMap);
        System.out.println(Arrays.toString(keys));
        System.out.println(weakHashMap.get(keys[0]));
        System.gc();
        System.out.println(weakHashMap);
    }
}

class Element {

    private final String ident;

    public Element(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Element && ident.equals(((Element) o).ident );
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
class Value extends Element {
    public Value(String id) {
        super(id);
    }
}

