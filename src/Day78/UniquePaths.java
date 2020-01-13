package Day78;

/**
 * @program: LeetForWork
 * @description: 62. Unique Paths
 * @author: Zekun Zhang
 * @create: 2020-01-13 19:14
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 && i != 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (i != 0 && j != 0) {u
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[m - 1][n - 1];
    }
}
