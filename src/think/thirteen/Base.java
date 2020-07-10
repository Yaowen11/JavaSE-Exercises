package think.thirteen;

import java.util.Base64;
import java.util.Date;

public class Base {
    public static void main(String[] args) {
        String token = "MQ==";
        int id = Integer.parseInt(new String(Base64.getDecoder().decode(token.getBytes())));
        System.out.println(id);
        Date date = new Date();
        System.out.println(date);
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("Aa".equals("BB"));
        System.out.println("19999999999999999".hashCode());   
    }
}