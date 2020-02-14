*java.util.LinkedList<E>*
```java
// 构造一个空链表
LinkedList();
// 构造一个链表，并将集合中所有的元素添加到这个链表中
LinedList(Collection<? extends E> elements);
// 将某个元素添加到列表的头部或尾部
void addFirst(E element);
void addLast(E element);
// 返回列表头部或尾部的元素
E getFirst();
E getLast();
// 删除并返回列表头部或尾部的元素
E removeFirst();
E removeLast();
```