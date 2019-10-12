package Day41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 30. Substring with Concatenation of All Words
 * @author: Zekun Zhang
 * @create: 2019-10-12 10:49
 */

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) return new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length, m = words[0].length();
        List<Integer> res = new ArrayList<>();
        for (String temp : words) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        for (int i = 0; i <= s.length() - m * n; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n, j = i;
            while (k > 0) {
                String temp = s.substring(j, j + m);
                if (copy.containsKey(temp) && copy.get(temp) != 0) {
                    copy.put(temp, copy.get(temp) - 1);
                    j += m;
                    k--;
                } else break;
            }
            if (k == 0) res.add(i);
        }
        return res;
    }
}
