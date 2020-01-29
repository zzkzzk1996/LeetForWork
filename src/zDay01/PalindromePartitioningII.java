package zDay01;

/**
 * @program: LeetForWork
 * @description: 132. Palindrome Partitioning II
 * @author: Zekun Zhang
 * @create: 2020-01-24 01:19
 */

public class PalindromePartitioningII {
    //Naive Backtracking
    private static int res = Integer.MAX_VALUE;
    public static int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        helper(s, 0);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private static void helper(String s, int cutNum) {
        if (s.length() == 0) {
            res = Math.min(res, cutNum - 1);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (check(s.substring(0, i + 1))) {
                helper(s.substring(i + 1), cutNum + 1);
            }
        }
    }

    private static boolean check(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    //DP
    public int minCutDp(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] cuts = new int[s.length()];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }
        return cuts[s.length() - 1];
    }
}
