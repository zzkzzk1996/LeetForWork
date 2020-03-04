package zDay15;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 155. Min Stack
 * @author: Zekun Zhang
 * @create: 2020-03-03 14:23
 */

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        min = Math.min(x, min);
        stack.push(x);
        minStack.push(min);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }
    }

    public int top() {
        return stack.isEmpty() ? 0 : stack.peek();
    }

    public int getMin() {
        return min;
    }
}
