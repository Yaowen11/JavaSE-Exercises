*java.util.prefs.Preferences*

```java
// 返回调用程序的用户的首选项根节点
Preferences userRoot();
// 返回系统范围的首选项根节点
Preferences systemRoot();
// 返回从当前节点由给定路径可以到达的节点。如果 path 为绝对路径，则从包含这个首选项节点的树的根节点开始查找。如果给定路径不存在相应的节点，则创建这样一个节点
Preferences node(String path);
// 返回当前用户树或系统树中的一个节点，其绝对节点路径对应类 cl 的包名
Preferences userNodeForPackage(Class cl);
Preferences systemNodeForPackage(Class cl);
// 返回属于这个节点的所有键
String[] keys();
// 返回与给定键关联的值，或者如果没有值与这个键关联，关联值不正确，或存储库不可用，返回默认值
String get(String key, String defval);
int getInt(String key, int defval);
long getLong(String key, long defval);
float getFloat(String key, float defval);
double getDouble(String key, double defval);
boolean getBoolean(String key, boolean defval);
byte[] getByteArray(String key, byte[] defval);
// 在这个节点存储一个键/值对
void put(String key, String value);
void putInt(String key, int value);
void potLong(String key, long value);
void putFloat(String key, float value);
void putDouble(String key, double value);
void putBoolean(String key, boolean value);
void putByteArray(String key, byte[] value);
// 将这个节点及其子节点的存储库写至指定的流
void exportSubtree(OutputStream out);
// 将这个节点（但不包括其子节点）的存储库写至指定流
void exportNode(OutputStream out);
// 导入指定流中包含的首选项
void importPreferences(InputStream in);
```

