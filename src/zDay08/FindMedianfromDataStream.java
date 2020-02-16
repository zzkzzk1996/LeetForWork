package zDay08;

import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description: 295. Find Median from Data Stream
 * @author: Zekun Zhang
 * @create: 2020-02-16 06:41
 */

public class FindMedianfromDataStream {

    private PriorityQueue<Integer> pq1;
    private PriorityQueue<Integer> pq2;
    /** initialize your data structure here. */
    public FindMedianfromDataStream() {
        pq1 = new PriorityQueue<>((a, b) -> (b - a));
        pq2 = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        pq2.offer(num);
        pq1.offer(pq2.poll());
        while (pq1.size() > pq2.size() + 1) {
            pq2.offer(pq1.poll());
        }
    }

    public double findMedian() {
        if (pq1.size() > pq2.size()) {
            return (double) (pq1.peek());
        } else {
            return (double) (pq1.peek() + pq2.peek()) / 2;
        }
    }
}
