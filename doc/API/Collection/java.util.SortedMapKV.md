*java.util.SortedMap<K, V>*
```java
// 返回在给定范围内的键条目的映射视图
SortedMap<K, V> subMap(K firstIncluded, K firstExcluded);
SortedMap<K, V> headMap(K firstExcluded);
SortedMap<K, V> tailMap(K firstIncluded);
// 返回对键进行排序的比较器。如果键是用 Comparable 接口的 compareTo 方法进行比较的，返回 null
Comparator<? super K> comparator();
// 返回映射中最小元素和最大元素
K firstKey();
k lastKey();
```