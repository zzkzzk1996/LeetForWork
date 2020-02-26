package zDay12;

/**
 * @program: LeetForWork
 * @description: 121. Best Time to Buy and Sell Stock
 * @author: Zekun Zhang
 * @create: 2020-02-23 19:53
 */

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i - 1]);
            dp1 = Math.max(dp1, -prices[i - 1]);
        }
        return dp0;
    }
}
