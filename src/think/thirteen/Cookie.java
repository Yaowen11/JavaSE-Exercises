package think.thirteen;

public class Cookie {
    public static void main(String[] args) {

        String[] loginCookies = {
            "PHPSESSID=d4a173550228e60e50d20350b002cf7d; path=/", 
            "PHPSESSID=d59341831db31a52750719fb3e5613e1; path=/", 
            "USER_NAME_COOKIE=deleted; expires=Thu, 01-Jan-1970 00:00:01 GMT", 
            "OA_USER_ID=1006001",
            "SID_1006001=db175844; expires=Sun, 02-Apr-2023 06:15:48 GMT; path=/"
        };
        final String phpSessionId = "PHPSESSID";
        final String oaUserId = "OA_USER_ID";
        final String sid = "SID_";
        for (String singleCookie : loginCookies) {
            // if (singleCookie.contains(phpSessionId)) {
            //     String value = singleCookie.substring(singleCookie.indexOf("=") + 1, 
            //     singleCookie.length() - (singleCookie.length() - singleCookie.indexOf(";")));
            //     System.out.println("php session: " + value);
            // }
            // if (singleCookie.contains(oaUserId)) {
            //     String value = singleCookie.substring(singleCookie.indexOf("=") + 1);
            //     System.out.println("uid: " + value);
            // }
            // if (singleCookie.contains(sid)) {
            //     String key = singleCookie.substring(0, singleCookie.indexOf("="));
            //     int index = singleCookie.length() - (singleCookie.length() - singleCookie.indexOf(";"));
            //     System.out.println(index);
            //     String value = singleCookie.substring(singleCookie.indexOf("=") + 1, index);      
            //     System.out.printf("key: %s value: %s\n", key, value);
            // }
            String[] keyValue = singleCookieKeyValue(singleCookie);
            System.out.printf("key: %s and key: %s\n", keyValue[0], keyValue[1]);
        }

        
    }

    private static String[] singleCookieKeyValue(String cookie) {
        final String split = ";";
        final String keyValueSplit = "=";
        String key = cookie.substring(0, cookie.indexOf(keyValueSplit));
        String value = cookie.substring(cookie.indexOf(keyValueSplit) + 1);
        if (cookie.contains(split)) {
            value = cookie.substring(
                    cookie.indexOf(keyValueSplit) + 1,
                    cookie.length() - (cookie.length() - cookie.indexOf(split)));
        }
        return new String[]{key, value};
    }
}