package zDay02;

/**
 * @program: LeetForWork
 * @description: 309. Best Time to Buy and Sell Stock with Cooldown
 * @author: Zekun Zhang
 * @create: 2020-02-03 11:55
 */

public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            if (i < 2) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1] );
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
            }
        }
        return dp[prices.length][0];
    }

    public int maxProfitImpro(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int sell = 0, preSell = 0;
        int buy = Integer.MIN_VALUE, preBuy = 0;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preBuy, preSell - price);
            preSell = sell;
            sell = Math.max(preSell, preBuy + price);
        }
        return sell;
    }
}
