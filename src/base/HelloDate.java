package base;

import java.lang.ref.Cleaner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zyw
 */
public class HelloDate {
    public static void main(String[] args) {
        try {
            System.exit(1);
        } finally {
            System.out.println("hello world");
        }
    }
    public static void dump() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Hello . it's: " + dateFormat.format(new Date()));
        System.out.println(System.getProperty("java.library.path"));
        System.getProperties().list(System.out);
    }
}
