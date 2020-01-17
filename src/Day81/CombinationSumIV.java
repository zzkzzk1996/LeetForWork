package Day81;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 377. Combination Sum IV
 * @author: Zekun Zhang
 * @create: 2020-01-16 19:29
 */

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0 && dp[i - nums[j]] != -1) {
                    dp[i] = dp[i] == -1 ? dp[i - nums[j]] : dp[i] + dp[i - nums[j]];
                }
            }
        }
        return dp[target] == -1 ? 0 : dp[target];
    }
}
