*java.util.concurrent.locks.Lock*
```java
// 返回一个与该锁相关的条件对象
Condition newCondition();
// 获取这个锁；如果锁同时被另一个线程拥有则发生阻塞
void lock();
// 释放这个锁
void unlock();
// 尝试获得锁而没有发生阻塞；如果成功返回真。这个方法会抢夺可用的锁，即使该锁有公平加锁策略，即便其他线程已经等待很久也是如此
boolean tryLock();
// 尝试获得锁，阻塞时间不会超过给定的值；如果成功返回 true
boolean tryLock(long time, Timeout unit);
// 获得锁，但是会不确定地发生阻塞。如果线程被中断，抛出 InterruptedException 异常
void lockInterruptibly();
```