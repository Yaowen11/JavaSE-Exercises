package se.i18n;

import java.text.MessageFormat;

/**
 * @author zhangyaowen
 */
public class UseMessage {
    public static void main(String[] args) {
        UseMessage useMessage = new UseMessage();
        useMessage.dumpMessage();
    }

    private void dumpMessage() {
        String msg = MessageFormat.format("On {2}, a {0} destroyed {1} houses and caused {3} of " +
                "damage.", "hurricane", 99, 23, 10.0);
        System.out.println(msg);
    }
}
