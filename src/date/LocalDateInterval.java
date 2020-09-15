package date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.*;

/**
 * @author z
 **/
public class LocalDateInterval {

    private static final DateTimeFormatter YEAR_MONTH = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        var start = LocalDate.parse("2020-04-10", YEAR_MONTH);
        var end = LocalDate.now();
        LocalDateInterval localDateInterval = new LocalDateInterval();
        var intervals = localDateInterval.intervalsOf(start, end);
        intervals.forEach((k,v)-> v.forEach((key, val)-> System.out.printf("key: %d, month: %d, year: %d\n", k, key.getValue(), val.getValue())));
        for (Map.Entry<Integer, Map<Month, Year>> monthYearEntry: intervals.entrySet()) {
            System.out.printf("key: %d, value: %s\n", monthYearEntry.getKey(), localDateInterval.yearMonthString(monthYearEntry.getValue()));
        }
        List<String> currentMonth = localDateInterval.monthLocalDate(Month.of(7), Year.now());
        currentMonth.forEach(System.out::println);
    }

    public Map<Integer, Map<Month, Year>> intervalsOf(LocalDate start, LocalDate end) {
        int startIndex = 0;
        Map<Integer, Map<Month, Year>> localDateMap = new HashMap<>();
        while (start.isBefore(end)) {
            localDateMap.put(startIndex++, Map.of(start.getMonth(), Year.of(start.getYear())));
            start = start.plusMonths(1);
        }
        return localDateMap;
    }

    public String yearMonthString(Map<Month, Year> yearMonthMap) {
        StringBuilder yearMonth = new StringBuilder();
        yearMonthMap.forEach((m, y)-> yearMonth.append(y.getValue()).append("年").append(m.getValue()).append("月"));
        return yearMonth.toString();
    }

    public List<String> monthLocalDate(Month month, Year year) {
        LocalDate currentMonthStart = LocalDate.of(year.getValue(), month.getValue(), 1);
        LocalDate nextMonthStart = currentMonthStart.plusMonths(1);
        List<String> currentMonthDateString = new ArrayList<>();
        while (currentMonthStart.isBefore(nextMonthStart)) {
            int dayOfMonth = currentMonthStart.getDayOfMonth();
            String dayOfMonthString = dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth);
            currentMonthDateString.add(currentMonthStart.getYear() + dayOfMonthString);
            currentMonthStart = currentMonthStart.plusDays(1);
        }
        return currentMonthDateString;
    }
}
