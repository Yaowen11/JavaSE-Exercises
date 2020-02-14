*java.util.concurrent.PriorityBlockingQueue<E>*
```java
/**
  * 构造一个无边界阻塞优先队列，用堆实现
  * @param initialCapacity 	优先队列的初始容量。默认值是11
  * @param comparator	用来对元素进行比较的比较器，如果没有指定，则元素必须实现 Comparable 接口
  */
PriorityBlockingQueue();
PriorityBlockingQueue(int initialCapacity);
PriorityBlockingQueue(int initialCapacity, Comparator<? super E> comparator);
```