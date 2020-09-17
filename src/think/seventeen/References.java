package think.seventeen;

import java.lang.ref.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author z
 **/
public class References {
    private static final ReferenceQueue<VerBig> rq = new ReferenceQueue<>();
    public static void checkQueue() {
        Reference<? extends VerBig> inq = rq.poll();
        if (inq != null) {
            System.out.println("Dn queue: " + inq.get());
        }
    }
    public static void main(String[] args) {
        int size = 3;
        LinkedList<SoftReference<VerBig>> softReferences = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            softReferences.add(new SoftReference<>(new VerBig("Soft " + i), rq));
            System.out.println("Just created: " + softReferences.getLast());
            checkQueue();
        }
        LinkedList<WeakReference<VerBig>> wa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            wa.add(new WeakReference<>(new VerBig("Weak " + i), rq));
            System.out.println("Just created: " + wa.getLast());
            checkQueue();
        }
        SoftReference<VerBig> s = new SoftReference<>(new VerBig("Soft"));
        WeakReference<VerBig> w = new WeakReference<>(new VerBig("Weak"));
        System.gc();
        LinkedList<PhantomReference<VerBig>> phantomReferences = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            phantomReferences.add(new PhantomReference<>(new VerBig("Phantom " + i), rq));
            System.out.println("Just created: " + phantomReferences.getLast());
            System.out.printf("is null: %b\n", phantomReferences.getLast().get() == null);
            checkQueue();
        }
    }
}

class VerBig {
    private static final int SIZE = 100000;
    private final long[] la = new long[SIZE];
    private final String ident;
    public VerBig(String id) { ident = id; }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + ident);
    }
}
