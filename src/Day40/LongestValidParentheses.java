package Day40;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 32. Longest Valid Parentheses
 * @author: Zekun Zhang
 * @create: 2019-10-10 22:09
 */

//TODO IMPORTANT

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
