package think.eleven;

import think.Constant;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author zyw
 * @date 2020/5/31 19:59
 */
public class QueueDemo {
    public static void main(String[] args) {
        dump();
    }
    public static void dump() {
        Queue<Integer> queue = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < Constant.TEN; i++) {
            queue.offer(i);
        }
//        while (queue.peek() != null) {
//            System.out.println(queue.remove() + " ");
//        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
