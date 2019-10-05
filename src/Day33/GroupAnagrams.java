package Day33;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 49. Group Anagrams
 * @author: Zekun Zhang
 * @create: 2019-10-03 11:15
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (Character c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder s = new StringBuilder("");
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    s.append(String.valueOf(count[i]) + String.valueOf((char)(i + 'a')));
                }
            }
            String temp = s.toString();
            if (map.containsKey(temp)) {
                List<String> list = map.get(temp);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
