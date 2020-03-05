package zDay17;

/**
 * @program: LeetForWork
 * @description: 1223. Dice Roll Simulation
 * @author: Zekun Zhang
 * @create: 2020-03-04 12:10
 */

public class DiceRollSimulation {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = (int)Math.pow(10, 9) + 7;
        int[][][] dp = new int[n][6][16];
        for (int i = 0; i < 6; i++) {
            dp[0][i][1] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int p = 0; p < 6; p++) {
                    for (int k = 1; k <= rollMax[p]; k++) {
                        if (p != j) {
                            dp[i][j][1] = (dp[i][j][1] + dp[i - 1][p][k]) % mod;
                        } else if (k < rollMax[j]) {
                            dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][p][k]) % mod;
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j < 6; j++) {
            for (int k = 1; k <= rollMax[j]; k++) {
                res = (res + dp[n - 1][j][k]) % mod;
            }
        }
        return res;
    }
}
