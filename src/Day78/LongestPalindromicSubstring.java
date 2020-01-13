package Day78;

/**
 * @program: LeetForWork
 * @description: 5. Longest Palindromic Substring
 * @author: Zekun Zhang
 * @create: 2020-01-13 18:36
 */

public class LongestPalindromicSubstring {
    // Naive
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String[] dp = new String[s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if (check(temp)) {
                    dp[i] = temp;
                    break;
                }
            }
        }

        String res = "";
        for (String str : dp) {
            if (str != null && res.length() < str.length()) {
                res = str;
            }
        }
        return res;
    }

    private boolean check(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String res = "";

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (max < j - i + 1) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
