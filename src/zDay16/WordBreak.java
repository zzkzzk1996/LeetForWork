package zDay16;

import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 139. Word Break
 * @author: Zekun Zhang
 * @create: 2020-03-03 14:54
 */

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i))) {
                    dp[i] = dp[j] || dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}
