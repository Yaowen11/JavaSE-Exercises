package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
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

    private int[] official(int[] inputs, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            int complement = target - inputs[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i};
            }
            map.put(inputs[i], i);
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
