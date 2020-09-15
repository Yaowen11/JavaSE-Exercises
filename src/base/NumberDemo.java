package base;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class NumberDemo {

    public static void main(String[] args) {
        random();
        Date date = new Date();
    }

    public static void decimal() {
        double balance = 9.99;
        balance -= 0.10f;
        System.out.println(balance);
        BigDecimal bigDecimal = BigDecimal.valueOf(9.99);
        BigDecimal accountFee = BigDecimal.valueOf(.1);
        BigDecimal r = bigDecimal.subtract(accountFee);
    }

    public static void random() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(100));
        System.out.println(threadLocalRandom.nextInt(175, 200));
    }

}
