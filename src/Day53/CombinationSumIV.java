package Day53;

/**
 * @program: LeetForWork
 * @description: 377. Combination Sum IV
 * @author: Zekun Zhang
 * @create: 2019-10-23 20:21
 */

//TODO DP

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
