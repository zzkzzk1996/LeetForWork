package zDay03;

/**
 * @program: LeetForWork
 * @description: 265. Paint House II
 * @author: Zekun Zhang
 * @create: 2020-02-04 06:44
 */

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int[] minIndex = new int[2];
        if (costs.length == 1) {
            minIndex = minValue(costs[0]);
            return costs[0][minIndex[0]];
        }
        if (costs[0].length < 2) return 0;
        int[][] dp = new int[costs.length + 1][costs[0].length];
        for (int i = 1; i <= costs.length; i++) {
            minIndex = minValue(dp[i - 1]);
            for (int k = 0; k < costs[0].length; k++) {
                if (k == minIndex[0]) {
                    dp[i][k] = costs[i - 1][k] + dp[i - 1][minIndex[1]];
                } else {
                    dp[i][k] = costs[i - 1][k] + dp[i - 1][minIndex[0]];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int k = 0; k < costs[0].length; k++) {
            res = Math.min(dp[costs.length][k], res);
        }
        return res;
    }

    private int[] minValue(int[] dp) {
        int minIndex = -1, secMinIndex = -1;
        int minValue = Integer.MAX_VALUE, secMinValue = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] < minValue) {
                secMinValue = minValue;
                secMinIndex = minIndex;
                minValue = dp[i];
                minIndex = i;
            } else {
                if (dp[i] < secMinValue) {
                    secMinValue = dp[i];
                    secMinIndex = i;
                }
            }
        }
        return new int[] {minIndex, secMinIndex};
    }
}
