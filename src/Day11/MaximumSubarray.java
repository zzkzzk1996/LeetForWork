package Day11;

/**
 * @program: LeetForWork
 * @description: 53. Maximum Subarray
 * @author: Zekun Zhang
 * @create: 2019-09-11 22:45
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i] + (temp < 0 ? 0 : temp);
            sum = Math.max(sum, temp);
        }
        return sum;
    }
}
