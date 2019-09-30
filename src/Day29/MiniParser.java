package Day29;

/**
 * @program: LeetForWork
 * @description: 385. Mini Parser
 * @author: Zekun Zhang
 * @create: 2019-09-29 19:34
 */

//TODO DESIGN

import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

public class MiniParser {

    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) return null;
        if (!s.startsWith("[")) return new NestedInteger(Integer.valueOf(s));
        NestedInteger res = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(res);
        int index = 1;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c) || c == '-') {
                int sign = 1;
                if (c == '-') {
                    sign = -1;
                    index++;
                }
                int num = s.charAt(index) - '0';
                index++;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                num = num * sign;
                stack.peek().add(new NestedInteger(num));
            } else if (c == '[') {
                NestedInteger nestedinteger = new NestedInteger();
                stack.peek().add(nestedinteger);
                stack.push(nestedinteger);
                index++;
            } else if (c == ']' || c == ',') {
                if (c == ']') {
                    stack.pop();
                }
                index++;
            }
        }
        return res;
    }
}
