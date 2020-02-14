*java.lang.Thread.UncaughtExceptionHandler*
```java
/**
  * 当一个线程因未捕获异常而终止，按规定要将客户报告记录到日志中
  * @params t 由于未捕获异常而终止的线程
  * @params e	未捕获的异常对象
  */
void uncaughtException(Thread t, Throwable e);
```

