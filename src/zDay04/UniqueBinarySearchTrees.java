package zDay04;

/**
 * @program: LeetForWork
 * @description: 96. Unique Binary Search Trees
 * @author: Zekun Zhang
 * @create: 2020-02-04 23:58
 */

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
