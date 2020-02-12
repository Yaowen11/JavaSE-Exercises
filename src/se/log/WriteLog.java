package se.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zhangyaowen
 */
public class WriteLog {

    private static final Logger MY_LOGGER = Logger.getLogger("my_log.properties");

    public static void main(String[] args) {
        useGlobalLogger();
        useOtherLogger();
    }

    private static void useGlobalLogger() {
        Logger global = Logger.getGlobal();
        global.setLevel(Level.FINER);
        useLogger(global);
    }

    private static void useOtherLogger() {
        useLogger(MY_LOGGER);
    }

    private static void useLogger(Logger logger) {
        logger.info("File->open menu item selected");
        logger.warning("File->open menu item selected");
        System.out.println("logger name: " + logger.getName());
        Level level = logger.getLevel();
        if (level != null) {
            System.out.println("logger level: " + level.getName());
        }
    }
}
