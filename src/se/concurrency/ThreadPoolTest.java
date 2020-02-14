package se.concurrency;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

class MatchCounterPool implements Callable<Integer>
{
    private File directory;

    private String keyword;

    private ExecutorService pool;

    private int count;

    MatchCounterPool(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            if (files == null) {
                return count;
            }
            for (File file: files) {
                if (file.isDirectory()) {
                    MatchCounterPool counter = new MatchCounterPool(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                } else {
                    if (search(file)) {
                        count++;
                    }
                }
            }
            for (Future<Integer> result : results) {
                try {
                    count += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {

        }
        return count;
    }

    boolean search(File file) {
        try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)) {
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                }
            }
            return found;
        } catch (IOException e) {
            return false;
        }
    }

}
/**
 * @author zhangyaowen
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g. /usr/local/jdk/src): ");
            String directory = in.nextLine();
            if (directory == null) {
                directory = "/Users/zhangyaowen/book/";
            }
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();
            if (keyword == null) {
                keyword = "java";
            }
            ExecutorService pool = Executors.newCachedThreadPool();
            MatchCounterPool counter = new MatchCounterPool(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);
            try {
                System.out.println(result.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            pool.shutdown();
            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size=" + largestPoolSize);
        }
    }
}
