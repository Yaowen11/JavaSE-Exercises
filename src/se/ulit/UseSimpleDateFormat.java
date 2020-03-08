package se.ulit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author z
 */
public class UseSimpleDateFormat {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


}
