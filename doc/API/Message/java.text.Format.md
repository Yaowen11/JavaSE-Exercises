*java.text.Format*
```java
// 按照格式器的规则格式化给定的对象，这个方法将调用 format(obj, new StringBuffer(), new FieldPosition(1)).toString()
String format(Object obj);
```