*java.util.concurrent.ExecutorService*

```java
// 提交指定的任务去执行
Future<T> submit(Callable<T> task);
Future<T> submit(Runnable task, T result);
Future<?> submit(Runnable task);
// 关闭服务，会先完成已经提交的任务而不再接收新的任务
void shutdown();
// 执行给定的任务，返回其中一个任务的结果。第二个方法若发生超时，抛出一个 TimeoutException 异常
T invokeAny(Collection<Callable<T>> tasks);
T invokeAny(Collection<Callable<T>> tasks, long timeout, TimeUnit unit);
// 执行给定的任务，返回所有任务的结果。第二个方法若发生超时，抛出一个 TimeoutException 异常
List<Future<T>> invokeAll(Collection<Callable<T>> tasks);
List<Future<T>> invokeAll(Collection<Callable<T>> tasks, long timeout, TimeUnit unit);
```