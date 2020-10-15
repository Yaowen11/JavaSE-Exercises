package se.base;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 1000 0000 0000 0000
 * 1110xxxx 10xxxxxx 10xxxxxx
 * 11101000 10000000 10000000 utf8 编码
 * E8 8080 16 进制
 */
public class CharCompare {
    public static void main(String[] args) {
        CharCompare charCompare = new CharCompare();
        String base = "🐍";
        charCompare.dump(base);
        System.out.println(charCompare.utf8Binary(base));
    }

    public void dump(String base) {
        byte[] bytes = base.getBytes(StandardCharsets.UTF_8);
        System.out.println(Long.toBinaryString(new BigInteger(1, bytes).longValue()));
        System.out.println(new String(bytes));
        char[] chars = base.toCharArray();
        for (char c : chars) {
            System.out.println(Integer.toBinaryString(c));
        }
        System.out.println(base.codePointAt(0));
    }

    public String utf8Binary(String base) {
        return Integer.toBinaryString(new BigInteger(1, base.getBytes(StandardCharsets.UTF_8)).intValue());
    }
}
