package date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.TimeUnit;

public class InstantDemo {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1991, 12, 15);
        LocalDate today = LocalDate.now();
        System.out.println(Period.between(birthday, today));
    }

    public static void instant() {
        Instant start = Instant.now();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }
}
