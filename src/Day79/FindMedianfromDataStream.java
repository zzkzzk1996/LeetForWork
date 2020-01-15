package Day79;

import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description: 295. Find Median from Data Stream
 * @author: Zekun Zhang
 * @create: 2020-01-15 16:44
 */

public class FindMedianfromDataStream {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    /** initialize your data structure here. */
    public FindMedianfromDataStream() {
        pq1 = new PriorityQueue<>((a, b) -> (b - a));
        pq2 = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        pq2.offer(num);
        pq1.offer(pq2.poll());
        if (pq1.size() - pq2.size() > 1) {
            int val = pq1.poll();
            pq2.offer(val);
        }
    }

    public double findMedian() {
        if (pq1.size() == pq2.size()) {
            return (pq1.peek() + pq2.peek()) / 2.0;
        } else return pq1.peek();
    }
}
