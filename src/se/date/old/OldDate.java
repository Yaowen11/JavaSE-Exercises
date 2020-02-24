package se.date.old;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author zhangyaowen
 */
public class OldDate {
    public static void main(String[] args) {
        dump();
    }

    public static void dump() {
        Date date = new Date();
        System.out.println(date);
        Instant now = Instant.now();
        System.out.println(now.atZone(ZoneId.of("Asia/Shanghai")));
    }
}
