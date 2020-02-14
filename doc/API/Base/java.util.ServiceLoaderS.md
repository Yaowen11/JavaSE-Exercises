*java.util.ServiceLoader<S>*

```java
// 创建一个服务加载器来加载实现给定服务接口的类
static <S> ServiceLoader<S> load(String<S> service);
// 生成一个懒加载服务类的迭代器，迭代器推进时类才会加载
Iterator<S> iterator();
```

