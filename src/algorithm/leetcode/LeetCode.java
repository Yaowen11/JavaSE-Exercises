package algorithm.leetcode;

/**
 * @author z
 * @date 2020/5/26 15:02
 */
public interface LeetCode {
    /**
     * 官方解法
     * @param org
     * @return
     */
    <T> void official(T ...org);

    /**
     * 个人解法
     * @param org
     * @return
     */
    <T> void mine(T ...org);

}
