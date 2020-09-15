package base;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ReferenceQueueExample {

    public static void main(String[] args) {
        ReferenceQueueExample referenceQueueExample = new ReferenceQueueExample();
        String init = "hello world";
        referenceQueueExample.example(init);
    }

    private <T> void example(T obj) {
        ReferenceQueue<T> referenceQueue = new ReferenceQueue<>();
        PhantomReference<T> p = new PhantomReference<>(obj, referenceQueue);
        obj = null;
        System.gc();
        try {
            Reference<T> reference = (Reference<T>) referenceQueue.remove();
            if (reference != null) {
                System.out.println(reference.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
