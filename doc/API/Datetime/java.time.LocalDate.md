*java.time.LocalDate*
```java
// 构造一个表示当前日期的对象
static LocalTime now();
// 构造一个表示给定日期的对象
static LocalTime of(int year, int month, int day);
// 得到当前日期的年
int getYear();
// 得到当前日期的月
int getMonthValue();
// 得到当前日期的日
int getDayOfMonth();
// 得到当前日期是星期几，返回 DayOfWeek 调用 getValue 来得到 1 ～ 7 之间的一个数，表示星期几
DayOfWeek getDayOfWeek()
// 生成当前日期之后的 n 天的日期
LocalDate plusDays(int n);
// 生成当前日期之前的 n 天的日期
LocalDate minusDays(int n);
// 解析给定的字符串并返回其中描述的，如果解析不成功，则抛出 DateTimeParseException 异常
static LocalDate parse(CharSequence);
static LocalDate parse(CharSequence text, DateTimeFormatter formatter);
```