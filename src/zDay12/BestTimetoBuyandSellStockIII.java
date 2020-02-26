package zDay12;

/**
 * @program: LeetForWork
 * @description: 123. Best Time to Buy and Sell Stock III
 * @author: Zekun Zhang
 * @create: 2020-02-24 11:53
 */

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        dp[0][0][0] = 0;
        for (int k = 2; k >= 0; k--) {
            dp[0][1][k] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int k = 2; k >= 1; k--) {
                dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k] + prices[i - 1]);
                dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - prices[i - 1]);
            }
        }
        return dp[prices.length][0][2];
    }
}
