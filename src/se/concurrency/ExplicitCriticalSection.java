package se.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyaowen
 */
class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally{
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally{
            lock.unlock();
        }
        store(temp);
    }
}

/**
 * @author zhangyaowen
 */
public class ExplicitCriticalSection {
    public static void main(String[] args) throws Exception {
        PairManager pairManager = new ExplicitPairManager1();
        PairManager pairManager1 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pairManager, pairManager1);
    }
}
