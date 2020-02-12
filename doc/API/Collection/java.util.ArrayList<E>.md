*java.util.ArrayList<E>*
```java
// 创建一个空数组列表
ArrayList<E>();
// 用指定容量构造一个空数组列表
ArrayList<E>(int initalCapacity);
// 在数组列表的尾端添加一个元素。永远返回 true, obj 为添加的元素
boolean add(E obj);
// 增加一个新元素 o 到该列表的指定下标处。index 插入位置（0 ~ size() -1 之间） obj 新元素
void add(int index, E obj);
// 清楚列表中的所有元素
void clear();
// 如果该列表包含元素 o, 则返回 true
boolean contains(o: Object);
// 返回该列表指定下标位置的元素值，index 介于 0 ~ size() -1 之间
E get(index: int);
// 返回列表中第一个匹配元素的下标
int indexOf(o: Object);
// 如果该列表不包含如何元素，则返回 true
boolean isEmpty();
// 返回列表中匹配的最后一个元素的下标
int lastIndexOf(o: Object);
// 去除列表中的一个元素。如果该元素被去除，则返回 true
boolean remove(o: Object);
// 删除一个元素，并将后面的元素向前移动。被删除的元素由返回值返回。index 被删除的元素位置 (0 ~ size() -1)
boolean remove(int index);
// 返回存储在数组列表中的当前元素数量，小于等于数组列表的容量
int size();
// 设置数组列表指定位置的元素值，这个操作将覆盖这个位置的原有内容，index 位置介于 0 - size() -1 之间，obj 新的值
void set(int index, E obj);
// 设置指定下标位置的元素，返回先前在此下标位置的元素
E set(index: int, o: E);
// 确保数组列表在不重新分配存储空间的情况下就能够保存给定数量的元素 capacity 需要的存储容量
void ensureCapacity(int capacity);
// 将数组列表的存储容量消减到当前尺寸
void trimToSize();
// 设置数组列表指定位置的元素值，这个操作将覆盖这个位置的原有内容
void set(int index, E obj);
```