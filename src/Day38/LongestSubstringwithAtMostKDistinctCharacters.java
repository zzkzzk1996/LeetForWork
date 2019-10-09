package Day38;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 340. Longest Substring with At Most K Distinct Characters
 * @author: Zekun Zhang
 * @create: 2019-10-08 21:46
 */

//TODO USE INT[] TO REPLACE HASHMAP

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 1;
        for (int start = 0, end = 0; end < s.length(); end++) {
            while (map.size() > k) {
                int temp = map.get(s.charAt(start));
                map.put(s.charAt(start), temp - 1);
                if (temp == 1) map.remove(s.charAt(start));
                start++;
            }
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            if (map.size() <= k) res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) return 0;
        int[] count = new int[256];
        int res = 1, num = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (count[s.charAt(end)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(start++)] > 0);
                num--;
            }
            res = Math.max(res, end - start + 1);
        }
        s.split()
        return res;
    }
}
