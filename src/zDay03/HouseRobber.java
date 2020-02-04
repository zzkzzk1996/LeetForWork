package zDay03;

/**
 * @program: LeetForWork
 * @description: 198. House Robber
 * @author: Zekun Zhang
 * @create: 2020-02-04 02:35
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public int robImpro(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int preMax = 0, max = 0;
        for (int price : nums) {
            int temp = max;
            max = Math.max(max, preMax + price);
            preMax = temp;
        }
        return max;
    }
}
