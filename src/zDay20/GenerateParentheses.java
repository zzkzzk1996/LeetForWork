package zDay20;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 22. Generate Parentheses
 * @author: Zekun Zhang
 * @create: 2020-03-10 18:30
 */

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            list.add("");
        } else {
            helper(list, "(", 1, 0, n);
        }
        return list;
    }

    private void helper(List<String> list, String s, int start, int end, int n) {
        if (s.length() == n * 2 || end > start) {
            if (start == end) list.add(s);
            return;
        }
        if (start < n) helper(list, s + "(", start + 1, end, n);
        if (end < start) helper(list, s + ")", start, end + 1, n);
    }
}
