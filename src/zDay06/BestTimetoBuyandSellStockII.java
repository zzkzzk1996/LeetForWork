package zDay06;

/**
 * @program: LeetForWork
 * @description: 122. Best Time to Buy and Sell Stock II
 * @author: Zekun Zhang
 * @create: 2020-02-12 16:33
 */

public class BestTimetoBuyandSellStockII {
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    public int maxProfit2(int[] prices) {
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
