package zDay02;

/**
 * @program: LeetForWork
 * @description: 121. Best Time to Buy and Sell Stock
 * @author: Zekun Zhang
 * @create: 2020-01-30 00:01
 */

public class BestTimetoBuyandSellStock {
    // Naive
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int res = -1, min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                dp[i] = prices[i] - min;
                res = Math.max(dp[i], res);
            } else {
                min = prices[i];
            }
        }
        return res == -1 ? 0 : res;
    }

    //Improvement
    public int maxProfitImpro(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = -1, min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                res = Math.max(prices[i] - min, res);
            } else {
                min = prices[i];
            }
        }
        return res == -1 ? 0 : res;
    }
}
