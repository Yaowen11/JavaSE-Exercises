*java.util.Arrays*
```java
// 返回包含 a 中元素的字符串，这些数据元素被放在括号内，并用逗号分隔
static String toString(type[] a);
/**
 * 返回与 a 类型相同的一个数组，其长度为 length 或者 end - start ，数组元素为 a 的值
 * @param start：起始下标（包含这个值）
 * @param end：终止下标（不包含这个值）。这个值可能大于 a.length。在这种情况下，结果为 0 或 false
 * @param length：拷贝的数据元素长度。如果 length 值大于 a.length，结果为 0 或 false；数组中只有前面 
 *。       length 个数据元素的拷贝值
**/
static type copyOf(type[] a, int length);
static type copyOfRange(type[] a, int start, int end);
// 使用 mergesort 算法对数组 a 中的元素进行排序。数组中的元素必须属于实现了 Comparable 接口的类，并且元素之间必须是可比较的
static void sort(Object[] a);
/**
 * 采用二分搜索算法查找值 v。如果查找成功，返回相同的下标值；否则，返回一个负数值 r。
 * -r -1 是为保持 a 有序 v 应插入的位置
 * @params start 起始下标（包含这个值）
 * @params end	终止下标（不包含这个值）
 */
static int binarySearch(type[] a, type v);
static int binarySerach(type[] a, int start, int end, type v);
// 将数组的所有数据元素值设置为 v
static void fill(type[] a, type v);
// 如果两个数组大小相同，并且下标相同的元素也均相同，返回 `true`
static boolean equals(type[] a，type[] b);
// 返回一个数组元素的列表视图。这个数组是可修改的，但其大小不可变
static <E> List<E> asList(E... array);
// 计算数组 a 的散列码
static int hashCode(type[] a);
// 产生一个流，它的元素是由数组中指定范围内的元素构成的
static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive);
```