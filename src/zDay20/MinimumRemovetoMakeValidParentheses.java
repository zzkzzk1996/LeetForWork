package zDay20;

/**
 * @program: LeetForWork
 * @description: 1249. Minimum Remove to Make Valid Parentheses
 * @author: Zekun Zhang
 * @create: 2020-03-10 18:30
 */

public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder("");
        int open = 0, close = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                sb.append(c);
                open++;
            } else if (c == ')') {
                if (close < open) {
                    sb.append(c);
                    close++;
                }
            } else {
                sb.append(c);
            }
        }

        if (open != close) {
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (open == close) break;
                if (sb.charAt(i) == '(') {
                    sb.deleteCharAt(i);
                    open--;
                }
            }
        }
        return sb.toString();
    }
}
