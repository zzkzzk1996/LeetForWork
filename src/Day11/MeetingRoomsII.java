package Day11;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 253. Meeting Rooms II
 * @author: Zekun Zhang
 * @create: 2019-09-11 20:42
 */

//TODO MULTI

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int end = 0;
        for (int start = 0; start < starts.length; start++) {
            if (starts[start] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }
        return res;
    }

}
