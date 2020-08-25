package se.concurrency.futures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zyw
 * @date 2020/8/25 20:17
 */
public class BlockFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final long start = System.currentTimeMillis();
        BlockFutures blockFutures = new BlockFutures();
        List<Long> result = blockFutures.blockFuture();
        System.out.printf("size: %d, result: %s\n", result.size(), result);
        final long end = System.currentTimeMillis();
        System.out.println("use millis: " + (end - start));
    }

    private List<Long> blockFuture() throws ExecutionException, InterruptedException {
        final int sleepSeconds = 3;
        final int size = 10;
        final int loop = 200000;
        ExecutorService executorService = Executors.newFixedThreadPool(size);
        List<Future<Long>> futures = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            futures.add(executorService.submit(() -> {
                var start = System.currentTimeMillis();
                for (int l = 0; l <= loop; l++) {
                    if (l / loop == 1) {
                        break;
                    }
                }
                TimeUnit.SECONDS.sleep(sleepSeconds);
                System.out.printf("current thread: %d, use millis: %d\n", Thread.currentThread().getId(), (System.currentTimeMillis() - start));
                return Thread.currentThread().getId();
            }));
        }
        System.out.println("future size: " + futures.size());
        List<Long> result = new ArrayList<>(size);
        List<Integer> doneThreads = new ArrayList<>(futures.size());
        for (int i = 0; i < futures.size(); i++) {
            doneThreads.add(i);
        }
        System.out.println(doneThreads);
        while (doneThreads.size() != 0) {
            for (int i = 0; i < futures.size(); i++) {
                if (futures.get(i).isDone() && doneThreads.contains(i)) {
                    result.add(futures.get(i).get());
                    doneThreads.remove(Integer.valueOf(i));
                }
            }
        }
        executorService.shutdown();
        return result;
    }
}
