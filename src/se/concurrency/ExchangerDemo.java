package se.concurrency;

import se.generic.generation.Generator;
import se.generic.generator.BasicGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    ExchangerProducer(Exchanger<List<T>> exchanger, Generator<T> generator, List<T> holder) {
        this.exchanger = exchanger;
        this.generator = generator;
        this.holder = holder;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (int i = 0; i < ExchangerDemo.size; i++) {
                holder.add(generator.next());
            }
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;
    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
        exchanger = ex;
        this.holder = holder;
    }
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                holder = exchanger.exchange(holder);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator<T> iterator = holder.iterator();
            while (iterator.hasNext()) {
                value = iterator.next();
                iterator.remove();
            }
        }
    }
}
/**
 * @author zhangyaowen
 */
public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            delay = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat> producerList = new CopyOnWriteArrayList<>();
        List<Fat> consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<>(xc, BasicGenerator.create(Fat.class), producerList));
        exec.execute(new ExchangerConsumer<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
