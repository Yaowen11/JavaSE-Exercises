*java.util.Queue<E>*
```java
// 如果队列没有满，将给定的元素添加到这个双端队列的尾部并返回 true。如果队列满了，第一个方法将抛出一个 IllegalStateException，而第二个方法返回 false
boolean add(E element);
boolean offer(E element);
// 假如队列不空，删除并返回这个队列头部的元素。如果队列是空的，第一个方法抛出 NoSuchElementException，而第二个方法返回 null
E remove();
E poll();
// 如果队列不空，返回这个队列头部的元素，但不删除。如果队列空，第一个方法将抛出一个 NoSuchElementException，而第二个方法返回 null
E  element();
E  peek();
```