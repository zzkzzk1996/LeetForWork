package zDay21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetForWork
 * @description: 49. Group Anagrams
 * @author: Zekun Zhang
 * @create: 2020-03-13 15:20
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (Character c : str.toCharArray()) {
                arr[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < arr.length; i++) {
                sb.append((char)('a' + i)).append(String.valueOf(arr[i]));
            }
            String temp = sb.toString();
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(str);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
