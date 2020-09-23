package think.twenty.temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair {
    private int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pair() { this(0, 0); }
    public int getX() { return  x; }
    public int getY() { return y; }
    public void incrementX() {
        x++;
    }
    public void incrementY() {
        y++;
    }

    class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    public void checkSatae() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());
    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {

        }
    }
    public abstract void increment();
}

class PairMangerOne extends PairManager {
    @Override public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairMangerTwo extends PairManager {
    @Override public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pairManager;
    public PairManipulator(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pairManager.getPair() + " checkCounter = " + pairManager.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pairManager;
    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCounter.incrementAndGet();
            pairManager.getPair().checkSatae();
        }
    }
}

public class CriticalSection {
    static void testApproaches(PairManager pairManager, PairManager pairManage) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator pairManipulator = new PairManipulator(pairManager);
        PairManipulator pairManipulator1 = new PairManipulator(pairManage);
        PairChecker pairChecker = new PairChecker(pairManager);
        PairChecker pairChecker1 = new PairChecker(pairManage);
        executorService.execute(pairManipulator);
        executorService.execute(pairManipulator1);
        executorService.execute(pairChecker);
        executorService.execute(pairChecker1);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException interruptedException) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: " + pairManager + "\npm2: " + pairManage);
        System.exit(0);
    }
    public static void main(String[] args) {
        PairManager pairManager = new PairMangerOne();
        PairManager pairManager1 = new PairMangerTwo();
        testApproaches(pairManager, pairManager1);
    }
}

