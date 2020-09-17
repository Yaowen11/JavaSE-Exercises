package think.seventeen;

import java.util.*;

/**
 * @author z
 **/
public class Synchronization {

    public static void main(String[] args) {
        Synchronization synchronization = new Synchronization();
        synchronization.failFast();
    }

    public void dump() {
        Collection<String> collection = Collections.synchronizedCollection(new ArrayList<>());
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<String> s = Collections.synchronizedSet(new HashSet<>());
        Set<String> ss = Collections.synchronizedSortedSet(new TreeSet<>());
        Map<String, String> m = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> sm = Collections.synchronizedSortedMap(new TreeMap<>());
    }

    public void failFast() {
        Collection<String> c = new ArrayList<>();
        c.add("hello");
        c.add("world");
        for (String s : c) {
            if ("hello".equals(s)) {
                c.add(s);
            }
        }
        System.out.println(c);
        Iterator<String> iterator = c.iterator();
        c.add("An object");
        try {
            String s = iterator.next();
        } catch (ConcurrentModificationException e) {
            System.out.println("concurrent modification exception");
        }
        Map<String, Integer> sMap = Map.of("a", 1, "b", 2, "c", 3, "d", 4);
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        sMap.forEach(stringIntegerMap::put);
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            entry.setValue(1);
        }
        System.out.println(stringIntegerMap);
    }
}
