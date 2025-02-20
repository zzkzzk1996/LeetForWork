package Day30;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 225. Implement Stack using Queues
 * @author: Zekun Zhang
 * @create: 2019-10-01 12:31
 */

public class ImplementStackusingQueues {
    class MyStack {
        Queue<Integer> queue;
        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.size() == 0;
        }
    }
}
