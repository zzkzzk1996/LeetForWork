package Day78;

import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 139. Word Break
 * @author: Zekun Zhang
 * @create: 2020-01-13 16:13
 */

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0);
    }

    private boolean helper(String s, HashSet<String> wordDict, int index) {
        if (index == s.length()) return true;
        for (int i = index + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index,  i)) && helper(s, wordDict, i)) return true;
        }
        return false;
    }

    // with memorization arrays
    public boolean wordBreak2(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean helper(String s, HashSet<String> wordDict, int index, Boolean[] memo) {
        if (index == s.length()) return true;
        if (memo[index] != null) return memo[index];
        for (int i = index + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index,  i)) && helper(s, wordDict, i, memo)) {
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
