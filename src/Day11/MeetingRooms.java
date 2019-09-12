package Day11;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 252. Meeting Rooms
 * @author: Zekun Zhang
 * @create: 2019-09-11 20:33
 */

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length < 2 || intervals[0] == null || intervals[0].length == 0) {
            return true;
        }
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
