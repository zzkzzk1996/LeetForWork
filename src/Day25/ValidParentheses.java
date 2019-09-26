package Day25;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 20. Valid Parentheses
 * @author: Zekun Zhang
 * @create: 2019-09-25 23:57
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
            }
        }
        return stack.isEmpty();
    }
}
