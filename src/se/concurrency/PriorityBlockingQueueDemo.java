package se.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<>();
    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }
    @Override
    public int compareTo(PrioritizedTask arg) {
        return Integer.compare(arg.priority, priority);
    }
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            System.out.println("catch interrupted exception");
        }
        System.out.println("current thread id: " + Thread.currentThread().getId() + this);
    }
    @Override
    public String toString() {
        return String.format(" current task priority [%1$-3d]", priority) + " Task " + id;
    }
    public String summary() {
        return "(" + id + ":" + priority + ")";
    }
    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService exec;
        public EndSentinel(ExecutorService e) {
            super(-1);
            exec = e;
        }
        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask prioritizedTask : sequence) {
                System.out.print(prioritizedTask.summary());
                if (++count % 5 == 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

class PrioritizedTaskProducer implements Runnable {
    private Random random = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService executorService;
    public PrioritizedTaskProducer(Queue<Runnable> q, ExecutorService e) {
        queue = q;
        executorService = e;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(random.nextInt(10)));
            Thread.yield();
        }
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            queue.add(new PrioritizedTask.EndSentinel(executorService));
        } catch (InterruptedException e) {
            System.out.println("catch interrupted exception prioritized task producer");
        }
        System.out.println("Finished PrioritizedTaskProducer");
    }
}

class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;
    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {
            System.out.println("Catch interrupted exception prioritized task consumer");
        }
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}
/**
 * @author zhangyaowen
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        Random rand = new Random(47);
        ExecutorService executorService = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        executorService.execute(new PrioritizedTaskProducer(queue, executorService));
        executorService.execute(new PrioritizedTaskConsumer(queue));
    }
}
