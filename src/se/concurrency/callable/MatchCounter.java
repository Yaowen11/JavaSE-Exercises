package se.concurrency.callable;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MatchCounter implements Callable<Integer>
{
    private File directory;

    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        MatchCounter counter = new MatchCounter(file, keyword);
                        FutureTask<Integer> task = new FutureTask<>(counter);
                        results.add(task);
                        Thread t = new Thread(task);
                        t.start();
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
            }
        } catch (InterruptedException e) {

        }
        return count;
    }

    private boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) {
                        found = true;
                    }
                }
                return found;
            }
        } catch (IOException e) {
            return false;
        }
    }
}
