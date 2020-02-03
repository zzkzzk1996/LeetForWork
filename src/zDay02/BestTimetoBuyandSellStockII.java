package zDay02;

/**
 * @program: LeetForWork
 * @description: 122. Best Time to Buy and Sell Stock II
 * @author: Zekun Zhang
 * @create: 2020-01-30 01:05
 */

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
            }
        }
        return dp[prices.length - 1];
    }

    public int maxProfitImpro(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
