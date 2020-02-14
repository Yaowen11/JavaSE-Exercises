*java.util.Properties*

```java
// 创建一个空属性映射
Properties();
// 用一组默认值创建一个属性映射，defaults 用于查找的默认值
Properties(Properties defaults);
// 获得一个属性，返回与 key 关联的值
String getProperty(String key);
// 获取 key 对应属性，不存在则返回 defaultValue
String getProperty(String key, String defaultValue);
// 设置一个属性，返回给定键之前设置的值
synchronized Object setProperty(String key, String value);
// 从指定源加载 properties
synchronized void load(InputStream inStream) throws IOException;
synchronized void load(Reader reader) throws IOException;
// 保存 properties 到目的，comment 注释
void store(Writer writer, String comments);
void store(OutputStream out, String comments);
```

