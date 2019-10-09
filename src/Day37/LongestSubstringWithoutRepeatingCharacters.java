package Day37;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 3. Longest Substring Without Repeating Characters
 * @author: Zekun Zhang
 * @create: 2019-10-07 23:57
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 1;
        map.put(s.charAt(0), start);
        for (int end = 1; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                maxLen = Math.max(maxLen, end - start);
                int newStart = map.get(c) + 1;
                while (start < newStart) {
                    map.remove(s.charAt(start));
                    start++;
                }
            }
            if (end == s.length() - 1) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            map.put(c, end);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        for (int end = 0, start = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            map.put(c, end + 1);
        }
        return maxLen;
    }
}
