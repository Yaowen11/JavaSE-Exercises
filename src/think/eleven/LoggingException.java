package think.eleven;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException {
    private static class LoggingExceptions extends Exception {
        private static Logger logger = Logger.getLogger("LoggingExceptions");
        LoggingExceptions () {
            StringWriter trace = new StringWriter();
            printStackTrace(new PrintWriter(trace));
            logger.severe(trace.toString());
        }
    }
    public static void main(String[] args) {
        try {
            throw new LoggingExceptions();
        } catch (LoggingExceptions e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingExceptions();
        } catch (LoggingExceptions e) {
            System.err.println("Caught " + e);
        }
    }
}