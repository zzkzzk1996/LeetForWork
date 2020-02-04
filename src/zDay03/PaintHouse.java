package zDay03;

/**
 * @program: LeetForWork
 * @description: 256. Paint House
 * @author: Zekun Zhang
 * @create: 2020-02-04 06:21
 */

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int[][] dp = new int[costs.length + 1][3];
        int res = 0;
        for (int i = 1; i <= costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
        }
        res = Math.min(dp[costs.length][0], Math.min(dp[costs.length][1], dp[costs.length][2]));
        return res;
    }
}
