package se.base;

/**
 * @author zhangyaowen
 */
public class BitOperation {
    public static void main(String[] args) {
        int n = 5785;
        // 如果二进制 n 从右边数第 4 位为 1，则返回 1，否则返回 0
        int fourthBitFormRight = (n & 0b1000) / 0b1000;
        int bits = (n & (1 << 3)) >> 3;
        System.out.println(fourthBitFormRight);
        System.out.println(bits);
        System.out.println(1 << 3 == 8);
        System.out.println(1 << 35 == 1 << 3);
    }
}
