package Day61;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description: 218. The Skyline Problem
 * @author: Zekun Zhang
 * @create: 2019-10-31 20:03
 */

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int pre = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (pre != cur) {
                List<Integer> temp = new ArrayList<>();
                temp.add(h[0]);
                temp.add(cur);
                res.add(temp);
                pre = cur;
            }
        }
        return res;
    }
}
