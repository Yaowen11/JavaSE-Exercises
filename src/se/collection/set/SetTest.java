package se.collection.set;

import java.util.*;

/**
 * @author zhangyaowen
 */
public class SetTest {

    void hashSet() {
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        try (Scanner in = new Scanner(System.in))
        {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= words.size() && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds");
    }

    void treeSet() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Bob");
        treeSet.add("Amy");
        treeSet.add("Carl");
        for (String s: treeSet) {
            System.out.println(s);
        }
    }

    void tree() {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        parts.add(new Item("zyw", 5199));
        System.out.println(parts);
        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
        NavigableSet<Item> sortByPartNumber = new TreeSet<>(Comparator.comparing(Item::getPartNumber));
        sortByPartNumber.addAll(parts);
        System.out.println(sortByPartNumber);
    }

    public static void main(String[] args) {
        SetTest setTest = new SetTest();
        setTest.treeSet();
        setTest.tree();
    }
}
