package zDay01;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 131. Palindrome Partitioning
 * @author: Zekun Zhang
 * @create: 2020-01-26 18:32
 */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, res, new ArrayList<>());
        return res;
    }

    private void helper(String s, List<List<String>> res, List<String> cur) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (check(s.substring(0, i + 1))) {
                cur.add(s.substring(0, i + 1));
                helper(s.substring(i + 1), res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean check(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
