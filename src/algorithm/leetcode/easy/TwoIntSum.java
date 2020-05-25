package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 * @author zyw
 * @date 2020/5/24 20:59
 */
public class TwoIntSum {

    private static final Integer MIN_LENGTH = 2;

    public int[] solution(int[] inputs, int target) {
        if (inputs.length < MIN_LENGTH) {
            return null;
        }
        if (inputs.length == MIN_LENGTH && Integer.sum(inputs[0], inputs[1]) == target) {
            return inputs;
        }
        for (int i = 0; i < inputs.length; i++) {
            for (int l = i+1; l < inputs.length; l++) {
                if (inputs[i] + inputs[l] == target) {
                    return new int[]{i, l};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5, 6};
        int target = 10;
        int[] right = new int[]{3, 5};
        TwoIntSum twoIntSum = new TwoIntSum();
        int[] result = twoIntSum.solution(test, target);
        boolean testResult = Arrays.equals(right, result);
        assert testResult : "failed";
    }
}
