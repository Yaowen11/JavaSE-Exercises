package se.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangyaowen
 */
class StaticLoad {

    public static final String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-mm-dd H:i:s"));

    transient protected static String proS = "pros";

    transient static Integer size = 100;

    static String defS = "defS";

    private static String priS = "pris";

    static {
        System.out.println(now);
    }

    static {
        System.out.println("this is static load");
    }

    public native static String getNow();

    synchronized protected native static String getProS ();

    static String getDefS() {
        return defS;
    }

    public static String getPriS() {
        return priS;
    }

    strictfp public static void addSize(Integer size) {
        StaticLoad.size = size;
    }
}
