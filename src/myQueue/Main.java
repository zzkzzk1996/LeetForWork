package myQueue;

import myQueue.implementation.ArrayCircularQueueImplementation;
import myQueue.implementation.ArrayQueueImplementation;
import myQueue.implementation.LinkedListQueueImplementation;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-30 12:13
 */

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new ArrayCircularQueueImplementation<>();
        for (int i = 0; i < 11; i++) {
            queue.offer(i);
        }
        queue.print();
        queue.poll();
        queue.print();
        System.out.print(queue.peek());
    }
}
