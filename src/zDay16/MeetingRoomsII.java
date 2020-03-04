package zDay16;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 253. Meeting Rooms II
 * @author: Zekun Zhang
 * @create: 2020-03-03 14:33
 */

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null) return 0;
        int res = 0, rooms = 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int start = 0, end = 0;
        for (int[] interval : intervals) {
            starts[start++] = interval[0];
            ends[end++] = interval[1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        start = end = 0;
        while (start < intervals.length && end < intervals.length) {
            if (starts[start] < ends[end]) {
                rooms++;
                start++;
            } else {
                rooms--;
                end++;
            }
            res = Math.max(rooms, res);
        }
        return res;
    }
}
