package think.seventeen;

import java.util.*;

/**
 * @author z
 **/
public class Dump {

    private static final Integer[] DATA = {22, 39, 19, 23, 49, 10, 29, 34, 41, 53};

    public static void main(String[] args) {
        Dump dump = new Dump();
        dump.dump();
    }

    public void dump() {
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer integer : DATA) {
            hashSet.add(integer);
            linkedHashSet.add(integer);
            treeSet.add(integer);
        }
        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
        System.out.println(treeSet.comparator());
        var a = Collections.singletonMap("key", "value");
        Collections.emptyList();
        Map.of("a", 1);
    }
}
