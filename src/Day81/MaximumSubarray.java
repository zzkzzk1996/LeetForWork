package Day81;

/**
 * @program: LeetForWork
 * @description: 53. Maximum Subarray
 * @author: Zekun Zhang
 * @create: 2020-01-16 11:40
 */

//Divide and Conquer

public class MaximumSubarray {
    public int maxSubArrayNaive(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int dp = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            dp = (dp > 0) ? dp + num : num;
            max = Math.max(dp, max);
        }
        return max;
    }
}
