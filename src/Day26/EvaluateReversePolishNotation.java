package Day26;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 150. Evaluate Reverse Polish Notation
 * @author: Zekun Zhang
 * @create: 2019-09-26 20:17
 */

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int c = stack.pop() + stack.pop();
                stack.push(c);
            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = b - a;
                stack.push(c);
            } else if (token.equals("*")) {
                int c = stack.pop() * stack.pop();
                stack.push(c);
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = b / a;
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
