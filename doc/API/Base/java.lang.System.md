*java.lang.System*
```java
// 如果有可能进行交互操作，就通过控制台窗口为交互的用户返回一个 `Console` 对象，否则返回 null。对于任何一个通过控制台窗口启动的程序，
// 都可使用 Console 对象。否则，其可用性将与所使用的系统有关
static Console console();
// 返回 Object.hashCode 计算出来的相同散列码（根据对象内存地址产生），即使 obj 所属的类已经重新定义了 hashCode 方法也是如此
static int identityHashCode(Object obj);
// 获取所有系统属性，应用必须有权限获取所有属性，否则会抛出一个安全异常
Properties getProperties();
/**
  * 获取给定键名对应的系统属性，应用必须有权限获取这个属性，否则抛出安全异常，以下属性总是获取
  * java.version
  * java.vendor
  * java.vendor.url
  * java.class.version
  * os.name
  * os.version
  * os.arch
  * file.separator
  * path.separator
  * line.sparator
  * java.specification.version
  * java.vm.specification.vendor
  * java.vm.sepcification.name
  * java.vm.version
  * java.vm.vendor
  * java.vm.name
  **/
String getProperty(String key);
```