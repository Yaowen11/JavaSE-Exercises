package se.enums;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author zhangyaowen
 */
public enum ConstantSpecificMethod {
    /**
     * date
     */
    DATA_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    /**
     * class path
     */
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("PATH");
        }
    },
    /**
     * version
     */
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod constantSpecificMethod: values()) {
            System.out.println(constantSpecificMethod.getInfo());
        }
    }
}
