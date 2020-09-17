package think.seventeen;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author z
 **/
public class PriorityInteger {

    static class Item implements Comparable<Item> {

        private final Integer i;

        public Item() {
            this.i = new Random().nextInt(100);
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(i, o.i);
        }

        public Integer getI() {
            return i;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            priorityQueue.add(new Item());
        }
        for (int i = 0; i < size; i++) {
            System.out.println(Objects.requireNonNull(priorityQueue.poll()).getI());
        }
    }
}
