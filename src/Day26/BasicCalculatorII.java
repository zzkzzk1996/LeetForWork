package Day26;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 227. Basic Calculator II
 * @author: Zekun Zhang
 * @create: 2019-09-26 21:58
 */

public class BasicCalculatorII {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        Character sign = '+';
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = c - '0';
                while ((i + 1) < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);
                sign = c;
                num = 0;
            }
        }
        for (int i : stack) {
            res += i;
        }

        return res;
    }

    public static int calculate1(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim().replaceAll(" +", "");
        int pre = 0;
        int res = 0;
        char sign = '+';
        int index = 0;
        while (index < s.length()) {
            Character c = s.charAt(index);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while ((index + 1) < s.length() && Character.isDigit(s.charAt(index + 1))) {
                    num = num * 10 + (s.charAt(index + 1) - '0');
                    index++;
                }
                if (sign == '+') {
                    res += pre;
                    pre = num;
                } else if (sign == '-') {
                    res += pre;
                    pre = -num;
                } else if (sign == '*') {
                    pre = pre * num;
                } else if (sign == '/') {
                    pre = pre / num;
                }
                index++;
            } else {
                sign = c;
                index++;
            }
        }
        return res + pre;
    }
}
