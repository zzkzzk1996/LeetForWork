package Day58;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 140. Word Break II
 * @author: Zekun Zhang
 * @create: 2019-10-28 16:13
 */

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(res, s, wordDict, "", 0);
        return res;
    }

    private static void helper(List<String> res, String s, List<String> wordDict, String cur, int pos) {
        if (pos == s.length()) {
            res.add(cur);
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String temp = s.substring(pos, i + 1);
            if (wordDict.contains(temp)) {
                helper(res, s, wordDict, (cur.equals("") ? "" : cur + " ") + temp, i + 1);
            }
        }
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    private HashMap<Integer, List<String>> map = new HashMap<>();

    private List<String> helper(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) return map.get(start);
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
