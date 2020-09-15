package date;

import java.time.*;

/**
 * @author z
 */
public class TimeZoneDemo {
    public static void main(String[] args) {
        TimeZoneDemo timeZoneDemo = new TimeZoneDemo();
        timeZoneDemo.dumpDuration();
        timeZoneDemo.zoneDuration();
    }

    public void dumpZone() {
        ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
    }

    public void dumpDuration() {
        LocalDateTime start = LocalDateTime.of(2019, 1, 26, 8, 10, 23, 0);
        LocalDateTime end = LocalDateTime.of(2019, 1, 26, 11, 10, 5, 0);
        Duration duration = Duration.between(start, end);
        System.out.printf("There are %d hours and %d minutes\n", duration.toHours(), duration.toMinutes());
    }

    public void zoneDuration() {
        ZonedDateTime start = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Shanghai"));
        ZonedDateTime end = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Denver"));
        Duration duration = Duration.between(start, end);
        System.out.printf("There are %d hours and %d minutes %n", duration.toHours(), duration.toMinutes());
    }

    Duration calculateTravelTime(ZonedDateTime departure, ZonedDateTime arrival) {
        return Duration.between(departure, arrival);
    }
}
