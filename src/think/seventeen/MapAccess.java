package think.seventeen;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author z
 **/
public class MapAccess {

    public static void main(String[] args) {
        MapAccess mapAccess = new MapAccess();
        mapAccess.linkedHashMapAccess();
        mapAccess.hashMapAccess();
    }

    public void linkedHashMapAccess() {
        dump(new LinkedHashMap<>(6, 0.75f,true));
    }

    public void hashMapAccess() {
        dump(new HashMap<>(6));
    }

    private void dump(Map<Integer, Integer> map) {
        int size = 6;
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
        System.out.println(map.put(0, 100));
        System.out.println("origin sort: ");
        map.forEach((k, v)-> System.out.print(k + ":" + v + " "));
        map.get(1);
        map.get(2);
        map.get(3);
        map.get(3);
        System.out.println("\naccess sort: ");
        map.forEach((k, v)-> System.out.print(k + ":" + v + " "));
        var values = map.values();
        values.clear();
        System.out.println("\noptions values():");
        System.out.println(map);
    }
}
