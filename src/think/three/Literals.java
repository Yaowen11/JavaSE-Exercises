package think.three;

/**
 * @author zyw
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;
        System.out.println("i1 : " + Integer.toBinaryString(i1));
        int i2 = 0x2F;
        System.out.println("i2 : " + Integer.toBinaryString(i2));
        int i3 = 0177;
        System.out.println("i3: " + Integer.toBinaryString(i3));
        char c = 0xffff;
        System.out.println("c: " + Integer.toBinaryString(c));
        byte b = 0x7f;
        System.out.println("B: " + Integer.toBinaryString(b));
        short s = 0x7fff;
        System.out.println("s: " + Integer.toBinaryString(s));
        long l = 0xffffffff;
        System.out.println("l: " + Long.toBinaryString(l));
        int x = 0x3dff;
        int y = 0x4bcf;
        System.out.println("xor: " + Integer.toBinaryString(x ^ y));
        System.out.println("&: " + Integer.toBinaryString(x & y));
        System.out.println("|: " + Integer.toBinaryString(x | y));
        System.out.println("x: " + Integer.toBinaryString(x));
        System.out.println("^: " + Integer.toBinaryString(~x));
    }
}
