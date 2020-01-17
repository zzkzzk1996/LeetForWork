package Day81;

import java.util.List;

/**
 * @program: LeetForWork
 * @description: 120. Triangle
 * @author: Zekun Zhang
 * @create: 2020-01-16 17:23
 */

public class Triangle {
    //Careful for the reversed iteration
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size()];
        int min = Integer.MAX_VALUE;
        for (List<Integer> level : triangle) {
            int size = level.size();
            for (int i = size - 1; i >= 0; i--) {
                if (i == 0) {
                    dp[i] = dp[i] + level.get(i);
                } else if (i == size - 1) {
                    dp[i] = dp[i - 1] + level.get(i);
                } else {
                    dp[i] = Math.min(dp[i - 1], dp[i]) + level.get(i);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }
}
