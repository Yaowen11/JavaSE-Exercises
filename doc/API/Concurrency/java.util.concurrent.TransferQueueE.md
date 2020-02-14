*java.util.concurrent.TransferQueue<E>*
```java
// 传输一个值，这个调用将阻塞，直到另一个线程将元素删除。
void transfer(E element);
// 给定的超时时间内传输这个值，这个调用将阻塞，直到另一个线程将元素删除，成功时返回 true
boolean tryTransfer(E element, long time, TimeUnit unit);
```