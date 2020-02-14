*java.util.SortedSet<E>*
```java
// 返回用于对元素进行排序的比较器。如果元素用 Comparable 接口的 comparaTo 方法进行比较则返回 null
Comparator<? super E> comparator();
// 返回有序集合中的最小或最大元素
E first();
E last();
// 返回给定范围内的元素视图
SortedSet<E> subSet(E firstIncluded, E firstExcluded);
SortedSet<E> headSet(E firstExcluded);
SortedSet<E> tailSet(E firstIncluded);
```