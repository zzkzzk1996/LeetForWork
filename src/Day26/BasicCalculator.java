package Day26;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 224. Basic Calculator
 * @author: Zekun Zhang
 * @create: 2019-09-26 21:31
 */

public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while ((i + 1) < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                res += num * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();

            }
        }
        return res;
    }
}
