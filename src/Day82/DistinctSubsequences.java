package Day82;

/**
 * @program: LeetForWork
 * @description: 115. Distinct Subsequences
 * @author: Zekun Zhang
 * @create: 2020-01-17 16:15
 */

public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i < sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
