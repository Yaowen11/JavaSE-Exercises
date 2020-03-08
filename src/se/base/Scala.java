package se.base;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 标量相关
 * @author z
 */
public class Scala {

    public static void main(String[] args) {
        Scala scala = new Scala();
        scala.dumpFloatCompare();
        scala.dumpString();
    }

    public void dumpFloatCompare() {
        float a = 0.9f - 0.8f;
        float b = 0.8f - 0.7f;
        int compare = Float.compare(a, b);
        System.out.printf("%f == %f = %d\n", a, b, compare);
        boolean com = a == b;
        System.out.printf("%f == %f = %b\n", a, b, com);
        float diff = 1e-6f;
        com = Math.abs(a - b) < diff;
        if (com) {
            System.out.printf("%f == %f = %b\n", a, b, com);
        }
        BigDecimal c = new BigDecimal("1.0");
        BigDecimal d = new BigDecimal("0.9");
        BigDecimal e = new BigDecimal("0.8");
        BigDecimal x = c.subtract(d);
        BigDecimal y = d.subtract(e);
        System.out.println(x.compareTo(y));
    }

    public void dumpString() {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        System.out.println(ary.length);
    }
}
