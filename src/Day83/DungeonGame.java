package Day83;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 174. Dungeon Game
 * @author: Zekun Zhang
 * @create: 2020-01-17 19:50
 */

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dungeon.length - 1][dungeon[0].length - 1] = 1;
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
                    if (dungeon[i][j] < 0) {
                        dp[i][j] += Math.abs(dungeon[i][j]);
                    }
                } else if (i == dungeon.length - 1 && j != dungeon[0].length - 1) {
                    dp[i][j] = dp[i][j + 1] - dungeon[i][j] > 0 ? dp[i][j + 1] - dungeon[i][j] : 1;
                } else if (i != dungeon.length - 1 && j == dungeon[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] - dungeon[i][j] > 0 ? dp[i + 1][j] - dungeon[i][j] : 1;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j] > 0 ? Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j] : 1;
                }
            }
        }
        return dp[0][0];
    }
}
