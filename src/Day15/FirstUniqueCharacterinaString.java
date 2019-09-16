package Day15;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 387. First Unique Character in a String
 * @author: Zekun Zhang
 * @create: 2019-09-15 22:10
 */

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) return i;
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            count[c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (count[c] == 1) return i;
        }
        return -1;
    }
}
