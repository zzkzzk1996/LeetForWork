package Day40;

/**
 * @program: LeetForWork
 * @description: 159. Longest Substring with At Most Two Distinct Characters
 * @author: Zekun Zhang
 * @create: 2019-10-10 18:53
 */

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0, numUnique = 0;
        int[] count = new int[256];
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (count[s.charAt(end)]++ == 0) numUnique++;
            while (numUnique > 2) {
                if (--count[s.charAt(start++)] == 0) numUnique--;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
