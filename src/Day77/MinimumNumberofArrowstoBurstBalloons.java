package Day77;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 452. Minimum Number of Arrows to Burst Balloons
 * @author: Zekun Zhang
 * @create: 2020-01-11 14:33
 */

public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int res = 1;
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                res++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return res;
    }
}
