package algorithm.sort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Merge {
    static AtomicInteger qSort1 = new AtomicInteger();
    static AtomicInteger qSort2 = new AtomicInteger();
    static AtomicInteger qSort3 = new AtomicInteger();
    public static void main(String[] args) {
        class Run implements Runnable {
            @Override
            public void run() {
                System.out.println("current thread %d: " + Thread.currentThread().getId());
                long i = 0;
                for(;;) {
                    ++i;
                    if (i == 800000000L) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int l = 0; l < 3; l++) {
            executorService.execute(new Run());
        }
    }

    static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) >> 1];
        while (i <= j) {
            qSort1.incrementAndGet();
            while (arr[i] < pivot) {
                ++i;
                qSort2.incrementAndGet();
            }
            while (arr[j] > pivot) {
                qSort3.incrementAndGet();
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }
}
