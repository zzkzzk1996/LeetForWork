package dynamicProgramming;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-01-13 18:24
 */

public class MultiKnapsack {
    public int knapsack01(int[] weight, int[] value, int[] nums, int C, int N) {
        int[] memo = new int[C + 1];

        for (int i = 0; i < N; i++) {
            for (int j = weight[i]; j <= C; j++) {
                for (int k = 0; k <= nums[i]; k++) {
                    if (j - k * weight[i] >= 0) {
                        memo[j] = Math.max(memo[j], k * value[i] + memo[j - k * weight[i]]);
                    }
                }
            }
        }
        return memo[C];
    }
}
