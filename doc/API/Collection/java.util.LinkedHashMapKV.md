*java.util.LinkedHashMap<K, V>*
```java
// 用指定容量、填充因子、访问顺序构造空散列链表映射表。accessOrder 为 true 时访问顺序，false 插入顺序
LinkedHashMap();
LinkedHashMap(int intialCapacity);
LinkedHashMap(int initialCapacity, float loadFactor);
LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder);
// 如果想删除 eldest 元素，并同时返回 true，就应该覆盖这个方法。eldest 参数是预期要删除的条目。这个方法将在条目添加到映射中之后调用。其默认的实现将返回 false。即在默认情况下，旧元素没有被删除。可以重新定义这个方法，以便有选择的访问 true。
protected boolean removeEldestEntry(Map.Entry<K, V> eldest);
```