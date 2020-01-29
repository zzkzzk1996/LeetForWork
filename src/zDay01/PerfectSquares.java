package zDay01;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 279. Perfect Squares
 * @author: Zekun Zhang
 * @create: 2020-01-29 12:40
 */

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
