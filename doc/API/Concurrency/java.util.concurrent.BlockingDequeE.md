*java.util.concurrent.BlockingDeque<E>*
```java
// 添加元素，满时阻塞
void putFirst(E element);
void putLast(E element);
// 移除并返回头元素或尾元素，为空时阻塞
E takeFirst();
E takeLast();
// 添加给定的元素，成功时返回 true，满时阻塞直至元素被添加或超时
boolean offerFirst(E element, long time, TimeUnit unit);
boolean offerLast(E element, long time, TimeUnit unit);
// 移动并返回头元素或尾元素，空时阻塞，直至元素可用或超时。失败时返回 null
E pollFirst(long time, TimeUnit unit);
E pollLast(long time, TimeUnit unit);
```

