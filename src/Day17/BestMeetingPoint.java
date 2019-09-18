package Day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 296. Best Meeting Point
 * @author: Zekun Zhang
 * @create: 2019-09-17 19:05
 */

// TODO GOOD IDEA

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) I.add(i);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) J.add(j);
            }
        }
        return min(I) + min(J);
    }

    private int min(List<Integer> list) {
        int sum = 0, i = 0, j = list.size() - 1;
        while (i < j) {
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    }
}
