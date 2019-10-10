package Day39;

/**
 * @program: LeetForWork
 * @description: 395. Longest Substring with At Least K Repeating Characters
 * @author: Zekun Zhang
 * @create: 2019-10-09 21:56
 */

//TODO TOO HARD

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k) return 0;
        int res = 0;
        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            res = Math.max(res, helper(s, k, uniqueTarget));
        }
        return res;
    }
    private int helper(String s, int k, int uniqueTarget) {
        int[] count = new int[256];
        int start = 0, end = 0, res = 0;
        int numUnique = 0, noLessThanK = 0;
        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) numUnique++;
            if (count[s.charAt(end++)] == k) noLessThanK++;
            while (numUnique > uniqueTarget) {
                if (count[s.charAt(start)]-- == k) noLessThanK--;
                if (count[s.charAt(start++)] == 0) numUnique--;
            }
            if (numUnique == uniqueTarget && numUnique == noLessThanK) {
                res = Math.max(res, end - start);
            }
        }
        return res;

    }
}
