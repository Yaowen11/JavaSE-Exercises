package se.concurrency.thread;

class Accessor implements Runnable {
    private final int id;
    public Accessor(int idn) {
        id = idn;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}