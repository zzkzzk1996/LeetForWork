package zDay07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 346. Moving Average from Data Stream
 * @author: Zekun Zhang
 * @create: 2020-02-15 10:59
 */

public class MovingAveragefromDataStream {

    private Queue<Integer> queue;
    private int len;
    private int sum;
    /** Initialize your data structure here. */
    public MovingAveragefromDataStream(int size) {
        queue = new LinkedList<>();
        if (size < 1) return;
        len = size;
        sum = 0;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > len) sum -= queue.poll();
        return (double)sum / queue.size();
    }
}
