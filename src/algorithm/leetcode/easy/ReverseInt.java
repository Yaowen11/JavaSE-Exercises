package algorithm.leetcode.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转,如果反转后整数溢出那么就返回 0
 * @author z
 * @date 2020/5/25 9:45
 */
public class ReverseInt {

    public int reverse(int x) {
        String x2s = String.valueOf(x);
        String[] x2sArray = x2s.split("");
        int condition = 0;
        if (x < 0) {
            condition = 1;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = x2sArray.length - 1; i >= condition; i--) {
            temp.append(x2sArray[i]);
        }
        int reverse = 0;
        try {
            reverse = Integer.parseInt(temp.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        if (x < 0) {
            return -reverse;
        }
        return reverse;
    }

    public int officialSolution(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int origin = -120;
        ReverseInt reverseInt = new ReverseInt();
        long start = System.currentTimeMillis();
        int reverse = reverseInt.reverse(origin);
        int official = reverseInt.officialSolution(origin);
        long end = System.currentTimeMillis();
        System.out.println(reverse);
        System.out.println(official);
        System.out.println("use millis: " + (end - start));
    }
}
