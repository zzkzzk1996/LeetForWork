package Day17;

/**
 * @program: LeetForWork
 * @description: 376. Wiggle Subsequence
 * @author: Zekun Zhang
 * @create: 2019-09-17 16:01
 */

/**
 * Greedy Algorithm
 */

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }
}
