package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

/**
 * @author z
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        DateFormatDemo dateFormatDemo = new DateFormatDemo();
        dateFormatDemo.dump();
        AgeCalculator ageCalculator = new AgeCalculator();
        LocalDate birthday = ageCalculator.getBirthday();
        Period age = ageCalculator.calculateAge(birthday);
        System.out.printf("Today you are %d years, %d months and %d days old\n", age.getYears(), age.getMonths(), age.getDays());

    }
    public void dump() {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        LocalDateTime example = LocalDateTime.of(2000, 3, 19, 10, 56, 59);
        System.out.println("Format 1: " + example.format(formatter));
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss");
        System.out.println("Format 2: " + example.format(formatter1));
    }

    static class AgeCalculator {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        public Period calculateAge(LocalDate birthday) {
            LocalDate today = LocalDate.now();
            return Period.between(birthday, today);
        }
        public LocalDate getBirthday() {
            System.out.println("Please enter your birthday " + "in yyyy-MM-dd format (e.g. 1980-9-28): ");
            try (Scanner scanner = new Scanner(System.in)) {
                String input = scanner.nextLine();
                return LocalDate.parse(input, formatter);
            }
        }
    }
}
