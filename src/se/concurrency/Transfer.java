package se.concurrency;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank {

    private final double[] accounts;

    private Lock bankLock = new ReentrantLock();

    private Condition sufficientFunds;

    Bank(int n, double init) {
        accounts = new double[n];
        Arrays.fill(accounts, init);
        sufficientFunds = bankLock.newCondition();
    }

    void syncTransfer(int from, int to, double amount) throws InterruptedException {
        synchronized (this) {
            while (accounts[from] < amount) {
                wait();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            notifyAll();
        }
    }

    void transfer(int from, int to, float amount) {
        if (accounts[from] > amount) {
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }
    }

    synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    int size() {
        return accounts.length;
    }

    void lockTransfer(int from, int to, float amount) {
        bankLock.lock();
        try  {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
    }

    void condition(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }
}

/**
 * @author zhangyaowen
 */
public class Transfer {

    public static final int COUNTS = 6;

    public static final double INITIAL_BALANCE = 1000;

    public static final double MAX_AMOUNT = 1000;

    public static final int DELAY = 10;

    Bank bank = new Bank(COUNTS, INITIAL_BALANCE);

    void unSyncTransfer() {
        for (int i = 0; i < COUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, (float) amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }

    void lockTransfer() {
        for (int i = 0; i < COUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                for (int l = 0; l < 4; l++) {
                    int toAccount = (int) (bank.size() * Math.random());
                    double amount = MAX_AMOUNT * Math.random();
                    try {
                        bank.syncTransfer(fromAccount, toAccount, amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }

    public static void main(String[] args) {
        Transfer transfer = new Transfer();
        transfer.lockTransfer();
    }
}
