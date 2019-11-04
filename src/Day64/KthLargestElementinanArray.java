package Day64;

import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description: 215. Kth Largest Element in an Array
 * @author: Zekun Zhang
 * @create: 2019-11-03 19:33
 */

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
