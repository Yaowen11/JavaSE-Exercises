*java.util.BitSet*

```java
// 创建一个位集
BitSet(int initialCapacity);
// 返回位集的逻辑长度，即 1 加上位集的最高设置位的索引
int length();
// 获得一个位
boolean get(int bit);
// 设置一个位
void set(int bit);
// 清除一个位
void clear(int bit);
// 这个位集与另一个位集进行逻辑 AND
void and(BitSet set);
// 这个位集与另一个位集进行逻辑 OR
void or(BitSet set);
// 这个位集与另一个位集进行逻辑 XOR
void xor(BitSet set);
// 清除这个位集中对应另一个位集中设置的所有位
void andNot(BitSet set);
```