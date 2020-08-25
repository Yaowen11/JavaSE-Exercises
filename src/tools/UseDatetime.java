package tools;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;

public class UseDatetime {
    private static final ZoneId LOCAL_ZONE_ID = ZoneId.of("Asia/Shanghai");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:m:s");
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now(LOCAL_ZONE_ID);
        System.out.println(localDateTime);
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println(timestamp);
        System.out.println(Timestamp.valueOf(localDateTime.format(DATE_TIME_FORMATTER)));
    }
}