package zDay04;

/**
 * @program: LeetForWork
 * @description: 312. Burst Balloons
 * @author: Zekun Zhang
 * @create: 2020-02-05 10:46
 */

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] arr = new int[nums.length + 2];
        for (int i = 1; i <= nums.length; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = arr[nums.length + 1] = 1;
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        return helper(1, nums.length, arr, dp);
    }

    private int helper(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        for (int k = i; k <= j; k++) {
            dp[i][j] = Math.max(dp[i][j], helper(i, k - 1, nums, dp) + nums[i - 1] * nums[k] * nums[j + 1] + helper(k + 1, j, nums, dp));
        }
        return dp[i][j];
    }
}
