package se.base;

/**
 * @author z
 */
public class Box {

    public static void main(String[] args) {
        Box box = new Box();
        box.dumpCompareInteger();
    }

    public void dumpCompareInteger() {
        Integer a = 17;
        Integer b = 17;
        System.out.println(a == b);
        Integer c = 273;
        Integer d = 273;
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(Integer.compare(c, d));
    }
}
