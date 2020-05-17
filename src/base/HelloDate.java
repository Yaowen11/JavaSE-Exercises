package base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zyw
 */
public class HelloDate {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Hello . it's: " + dateFormat.format(new Date()));
        System.out.println(System.getProperty("java.library.path"));
        System.getProperties().list(System.out);
    }
}
