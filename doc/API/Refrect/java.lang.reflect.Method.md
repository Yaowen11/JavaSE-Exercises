*java.lang.reflect.Method*

```java
// 返回一个用于描述类中定义的构造器、方法活域的 Class 对象
Class getDeclaringClass();
// 返回一个用于描述方法抛出的异常类型的 Class 对象数组
Class[] getExceptionTypes();
// 返回一个用于描述修饰符的整型数值。使用 Modifier 类中的这个方法可以分析这个返回值
int getModifiers();
// 返回一个用于描述构造器、方法或域的字符串
String getName();
// 返回一个用于描述参数类型的 Class 对象数组
Class[] getParameterTypes();
// 返回一个用于描述返回类型的 Class 对象
Class getReturnType();
// 如果这个方法被声明为泛型方法，则获得泛型类型变量，否则返回长度为 0 的数组
TypeVariable[] getTypeParameters();
// 获得这个方法被声明的泛型返回类型
Type getGenericReturnType();
// 获得这个方法被声明的泛型参数类型。如果这个方法没有参数，返回长度为 0 的数组
Type[] getGenericParameterTypes();
// 调用这个对象所描述的方法，传递给定参数，并返回方法的返回值。对于静态方法，把 null 作为隐式参数传递。在使用包装器传递基本类型的值时，基本类型的返回值必须是未包装的
Object invoke(Object implicitParameter, Object[] explicitParamenters);
```