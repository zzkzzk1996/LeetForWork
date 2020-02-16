package zDay07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 362. Design Hit Counter
 * @author: Zekun Zhang
 * @create: 2020-02-15 11:39
 */

public class DesignHitCounter {

    private Queue<Integer> queue;
    private int hits;
    /** Initialize your data structure here. */
    public DesignHitCounter() {
        queue = new LinkedList<>();
        this.hits = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
        hits++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (hits > 0 && timestamp - queue.peek() >= 300) {
            queue.poll();
            hits--;
        }
        return hits;
    }
}
