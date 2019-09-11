package Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 56. Merge Intervals
 * @author: Zekun Zhang
 * @create: 2019-09-10 22:32
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[] {start, end});
                end = intervals[i][1];
                start = intervals[i][0];
            }
        }
        res.add(new int[] {start, end});
        return res.toArray(new int[res.size()][2]);
    }
}
