package zDay22;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 3. Longest Substring Without Repeating Characters
 * @author: Zekun Zhang
 * @create: 2020-03-14 20:48
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 1, i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                int temp = map.get(s.charAt(j));
                while (i <= temp) {
                    map.remove(s.charAt(i++));
                }
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, map.size());
        }
        return res;
    }
}
