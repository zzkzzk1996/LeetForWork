package Day15;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 347. Top K Frequent Elements
 * @author: Zekun Zhang
 * @create: 2019-09-15 22:43
 */

//TODO IMPORTANT: TREEMAP & BUCKET SORT

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> map.get(x) - map.get(y));

        for (int n : map.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
