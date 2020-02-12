*java.lang.Throwable*
```java
// 构造一个新的 Throwable 对象，这个对象没有详细的描述信息
Throwable();
// 构造一个新的 throwable 对象，这个对象带有特定的详细描述信息。习惯上，所有派生的异常类都支持一个默认的构造器和一个带有详细描述信息的构造器
Throwable(String message);
// 用给定的原因构造一个 Throwable 对象
Throwable(Throwable cause);
Throwable(String message, Throwable cause);
// 将这个对象设置为原因。如果这个对象已经被设置为原因，则抛出一个异常。返回 this 引用
Throwable initCause(Throwable cause);
// 获得设置这个对象的原因的异常对象。如果没有设置原因，则返回 null
Throwable getCause();
// 获得构造这个对象时调用堆栈的跟踪
StackTraceElement[] getStackTrace();
// 为这个异常增加一个抑制异常。这出现在带资源的 try 语句中，其中 t 是 close 方法抛出的一个异常
void addSuppressed(Throwable t);
// 得到这个异常的所有抑制异常。一般来说，这些是带资源的 try 语句中 close 方法抛出的异常
Throwable[] getSuppressed();
// 获得 Throwable 对象的详细描述信息
String getMessage();
// 将 Throwable 对象和栈的轨迹输出到标准错误流
void printStackTrace();
```

