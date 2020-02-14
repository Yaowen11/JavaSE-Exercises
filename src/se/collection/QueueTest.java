package se.collection;

import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangyaowen
 */
public class QueueTest {
    <T> void priority(Queue<T> queue) {
        System.out.println("Iterating over elements...");
        for (T date: queue) {
            System.out.println(date);
        }
        System.out.println("Removing elements...");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));
        QueueTest queueTest = new QueueTest();
        queueTest.priority(pq);
    }
}
