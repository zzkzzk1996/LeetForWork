package zDay14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: LeetForWork
 * @description: 1029. Two City Scheduling
 * @author: Zekun Zhang
 * @create: 2020-03-01 20:54
 */

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            res += costs[i][0] + costs[i + costs.length / 2][1];
        }
        return res;
    }
}
