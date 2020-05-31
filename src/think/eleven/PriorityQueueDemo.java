package think.eleven;

import think.Constant;

import java.util.*;

/**
 * @author zyw
 * @date 2020/5/31 20:34
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        show();
    }
    public static void show() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Double> doublePriorityQueue = new PriorityQueue<>();
        final Random random = new Random();
        for (int i = 0; i < Constant.TEN; i++) {
            priorityQueue.offer(random.nextInt(1000));
            doublePriorityQueue.offer(random.nextDouble());
        }
        dump(priorityQueue);
        dump(doublePriorityQueue);
        List<Integer> integers = List.of(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(integers.size(), Collections.reverseOrder());
        priorityQueue1.addAll(integers);
        dump(priorityQueue1);
        final String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = List.of(fact.split(" "));
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPriorityQueue.addAll(strings);
        dump(stringPriorityQueue);
        Set<Character> characterSet = new HashSet<>();
        for (char c: fact.toCharArray()) {
            characterSet.add(c);
        }
        PriorityQueue<Character> characterPriorityQueue = new PriorityQueue<>(characterSet);
        dump(characterPriorityQueue);
    }
    public static void dump(Queue queue) {
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
