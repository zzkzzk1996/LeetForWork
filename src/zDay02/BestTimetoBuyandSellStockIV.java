package zDay02;

/**
 * @program: LeetForWork
 * @description: 188. Best Time to Buy and Sell Stock IV
 * @author: Zekun Zhang
 * @create: 2020-02-03 10:28
 */

public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) return 0;
        if (k > prices.length / 2) return helper(prices);
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int temp = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + temp);
                temp = Math.max(temp, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    private int helper(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
