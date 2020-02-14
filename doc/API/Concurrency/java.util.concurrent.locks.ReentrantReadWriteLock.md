*java.util.concurrent.locks.ReentrantReadWriteLock*
```java
// 得到一个可以被多个读操作共用的读锁，但会排斥所有写操作
Lock readLock();
// 得到一个写锁，排斥所有其他的读操作和写操作
Lock writeLock();
```