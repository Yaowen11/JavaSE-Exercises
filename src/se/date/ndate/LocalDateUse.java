package se.date.ndate;

import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.time.*;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * @author zhangyaowen
 */
public class LocalDateUse {

    public static void main(String[] args) {
        dump();
    }

    public static void dump() {
        LocalDateUse localDateUse = new LocalDateUse();
        localDateUse.dumpInstant();
        localDateUse.dumpZoneId();
        localDateUse.dumpZoneDateTime();
        localDateUse.dumpTemporalAdjusters();
        localDateUse.dumpFormat();
    }

    private void dumpLocalDate() {
        LocalDate localDate = LocalDate.of(2014, 3, 18);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        int len = localDate.lengthOfMonth();
        boolean leapYear = localDate.isLeapYear();
        LocalDate today = LocalDate.now();
        int thisYear = today.get(ChronoField.YEAR);
        int thisMonth = today.get(ChronoField.MONTH_OF_YEAR);
    }

    private void dumpLocalTime() {
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        LocalTime current = LocalTime.now();
        int currentHour = current.get(ChronoField.HOUR_OF_DAY);
        int currentMinute = current.get(ChronoField.MINUTE_OF_HOUR);
        int currentSecond = current.get(ChronoField.SECOND_OF_MINUTE);
    }

    private void dumpLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        LocalDate date = LocalDate.parse("2019-12-10");
        LocalTime time = LocalTime.parse("12:01:32");
        LocalDateTime localDateTime1 = LocalDateTime.of(date, time);
        LocalDateTime localDateTime2 = date.atTime(13, 13, 42);
        LocalDateTime localDateTime3 = date.atTime(time);
        LocalDateTime localDateTime4 = time.atDate(date);
        String dateTime = "2019-12-10 13:13:23";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        LocalDateTime localDateTime6 = LocalDateTime.parse(dateTime, dateTimeFormatter);
        System.out.printf("local date time parse ISO_DATE_TIME string: %s\n", localDateTime6);
    }

    private void dumpInstant() {
        Instant instant = Instant.now();
        System.out.println("epoch second: " + instant.getEpochSecond());
        System.out.println(Instant.ofEpochSecond(1000));
        System.out.println(instant);
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(instant.getEpochSecond(),
                instant.getNano(),
                ZoneOffset.ofTotalSeconds(28800));
        LocalDateTime localDateUtc = LocalDateTime.ofEpochSecond(instant.getEpochSecond(),
                instant.getNano(),
                ZoneOffset.of("+08:00"));
        System.out.println(localDateTime.getNano());
        System.out.println(localDateUtc);
    }

    private void dumpDuration() {

    }

    private void dumpPeriod() {

    }

    private void dumpZoneId() {
        System.out.println(ZoneId.getAvailableZoneIds());
    }

    private void dumpZoneDateTime() {
        ZonedDateTime bj = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Shanghai"));
        System.out.println(bj);
    }

    private void dumpTemporalAdjusters() {
        TemporalAdjuster next = w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);
            return result;
        };
        System.out.println(next);
        System.out.println(TemporalAdjusters.firstDayOfMonth());
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.lastDayOfMonth();
    }

    private void dumpFormat() {
        String parseTime = "1991-12-15 01:47:23";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
        System.out.println(dateTimeFormatter);
        LocalDate bir = LocalDate.parse("1903-06-14");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("1969-07-16 03:32:00-0400",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXX"));
        System.out.println(zonedDateTime);

        ZonedDateTime apo = ZonedDateTime.of(1969, 7, 16,9,32,0,0, ZoneId.of("Asia/Shanghai"));
        String formatted = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(apo);
        System.out.println(formatted);

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        formatted = formatter.format(apo);
        System.out.println(formatted);

        formatted = formatter.withLocale(Locale.CHINA).format(apo);
        System.out.println(formatted);

        formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
        formatted = formatter.format(apo);
        System.out.println(formatted);

        LocalDate chu = LocalDate.parse("1993-06-14");
        System.out.println("chu: " + chu);
        apo = ZonedDateTime.parse("1969-07-16 03:32:00-0400", DateTimeFormatter.ofPattern("yyyy" +
                "-MM-dd HH:mm:ssXX"));
        System.out.println("apo: " + apo);
        for (DayOfWeek w: DayOfWeek.values()) {
            System.out.print(w.getDisplayName(TextStyle.FULL, Locale.CHINA) + " ");
        }
    }
}
