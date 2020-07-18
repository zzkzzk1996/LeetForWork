package Day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 57. Insert Interval
 * @author: Zekun Zhang
 * @create: 2019-09-10 20:41
 */

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0 || newInterval == null || newInterval.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        List<int[]> res = new ArrayList<>();
        // int i = 0;
        boolean flag = true;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][1]) {
                res.add(new int[] {intervals[i][0], intervals[i][1]});
            } else if (newInterval[1] >= intervals[i][0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                if (flag) {
                    res.add(new int[] {newInterval[0], newInterval[1]});
                    flag = false;
                }
                res.add(new int[] {intervals[i][0], intervals[i][1]});
            }
        }
        if (flag) {
            res.add(new int[] {newInterval[0], newInterval[1]});
        }
        return res.toArray(new int[res.size()][2]);
    }


    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(new int[] {newInterval[0], newInterval[1]});
        while (i < intervals.length) {
            list.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
