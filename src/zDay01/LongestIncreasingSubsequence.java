package zDay01;

/**
 * @program: LeetForWork
 * @description: 300. Longest Increasing Subsequence
 * @author: Zekun Zhang
 * @create: 2020-01-28 07:17
 */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++)  {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
