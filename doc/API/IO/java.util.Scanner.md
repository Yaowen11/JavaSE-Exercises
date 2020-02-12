*java.util.Scanner*
```java
// 用给定的输入流创建一个 Scanner 对象
Scanner (InputStram in);
// 构造一个从给定文件读取数据的 Scanner
Scanner (File f);
// 构造一个从给定字符串读取数据的 Scanner
Scanner (String data);
// 关闭该 Scanner
void close();
// 如果该 Scanner 还有更多数据，则返回 true
boolean hasNext();
// 检测是否还有表示整数或浮点数的下一个字符序列
boolean hasNextInt();
boolean hasNextDouble();
// 读取输入的下一行内容
String nextLine();
// 读取输入的下一个单词（以空格作为分隔符）
String next();
// 读取输入的一个 int
int nextInt();
// 读取下一个 double
double nextDouble();
// 读取下一个 short
short nextShort();
// 读取下一个 long
long nextLong();
// 从该 Scanner 中读取下一个标记作为 byte 值返回
byte nextByte();
// 设置 Scanner 的分隔符，并且返回该 scanner
useDelimiter(pattern: String);
```