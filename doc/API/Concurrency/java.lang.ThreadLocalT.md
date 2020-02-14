*java.lang.ThreadLocal<T>*
```java
// 得到这个线程的当前值。如果是首次调用 get，会调用 initialize 来得到这个值
T get();
// 应覆盖这个方法来提供一个初始值。默认情况下，返回 null
protedcted ininialize();
// 为这个线程设置一个新值
void set(T t);
// 删除对应这个线程的值
void remove();
// 创建一个线程局部变量，其初始值通过调用给定的 supplier 生成
static <S> ThreadLocal<S> withInitial(Supplier<? extends s> supplier);
```