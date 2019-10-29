package Day59;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 253. Meeting Rooms II
 * @author: Zekun Zhang
 * @create: 2019-10-29 17:14
 */

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (end[j] > start[i]) count++;
            else j++;
        }
        return count;
    }
}
