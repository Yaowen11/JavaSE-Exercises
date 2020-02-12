*java.util.logging.FileHandler*
```java
/**
 * 构造一个文件处理器
 * @param pattern	构造日志文件名的模式
 * @param limit		在打开一个新日志文件之前，日志文件可以包含的近似最大字节数
 * @param count     循环序列的文件数量
 * @param append	新构造的文件处理器对象应该追加在一个已存在的日志尾部，则为 true
 */
FileHandler(String pattern);
FileHandler(String pattern, boolean append);
FileHandler(String pattern, int limit, int count);
FileHandler(String pattern, int limit, int count, boolean append);
```

