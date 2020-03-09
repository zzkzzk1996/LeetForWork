package zDay19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 140. Word Break II
 * @author: Zekun Zhang
 * @create: 2020-03-08 18:53
 */

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    private HashMap<Integer, List<String>> map = new HashMap<>();

    private List<String> helper(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String temp = s.substring(start, end);
            if (wordDict.contains(temp)) {
                List<String> list = helper(s, wordDict, end);
                for (String l : list) {
                    res.add(temp + (l.equals("") ? "" : " " + l));
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
