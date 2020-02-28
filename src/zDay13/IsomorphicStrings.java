package zDay13;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 205. Isomorphic Strings
 * @author: Zekun Zhang
 * @create: 2020-02-27 14:00
 */

public class IsomorphicStrings {
    public boolean isIsomorphic1(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null ^ t == null || s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (!map.containsKey(sc) && !map.containsValue(tc)) {
                map.put(sc, tc);
            } else if (map.containsKey(sc)){
                if (map.get(sc) != tc) return false;
            } else return false;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null ^ t == null || s.length() != t.length()) return false;
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (m1[sc] != m2[tc]) return false;
            m1[sc] = i + 1;
            m2[tc] = i + 1;
        }
        return true;
    }
}
