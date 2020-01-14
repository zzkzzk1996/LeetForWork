package dynamicProgramming;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-01-13 18:16
 */

public class CompleteKnapsack {
    public int knapsack(int[] weight, int[] value, int C, int N) {
        int[][] memo = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= C; j++) {
                if (j < weight[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], value[i - 1] + memo[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return memo[N][C];
    }

    public int knapsackImpro(int[] weight, int[] value, int C, int N) {
        int[] memo = new int[C + 1];


        for (int i = 0; i < N; i++) {
            for (int j = C; j >= weight[i]; j--) {
                memo[j] = Math.max(memo[j], value[i] + memo[j - weight[i]]);
            }
        }
        return memo[C];
    }

    public int knapsackImpro2(int[] weight, int[] value, int C, int N) {
        int[] memo = new int[C + 1];


        for (int i = 0; i < N; i++) {
            for (int j = weight[i]; j <= C; j++) {
                memo[j] = Math.max(memo[j], value[i] + memo[j - weight[i]]);
            }
        }
        return memo[C];
    }


    public int knapsackFollowup(int[] weight, int[] value, int C, int N) {
        int[][] memo = new int[N + 1][C + 1];

        String[][] path = new String[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= C; j++) {
                if (j < weight[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                    if (path[i - 1][j] != null) {
                        path[i][j] = path[i - 1][j];
                    }
                } else {
                    if (memo[i - 1][j] > value[i - 1] + memo[i - 1][j - weight[i - 1]]) {
                        memo[i][j] = memo[i - 1][j];
                        if (path[i - 1][j] != null) {
                            path[i][j] = path[i - 1][j];
                        }
                    } else {
                        memo[i][j] = value[i - 1] + memo[i - 1][j - weight[i - 1]];
                        if (path[i - 1][j - weight[i - 1]] == null) {
                            path[i][j] = i + "";
                        } else {
                            path[i][j] = path[i - 1][j - weight[i - 1]] + " " + i;
                        }
                    }
                }
            }
        }

        for (String[] s : path) {
            System.out.println(Arrays.toString(s));
        }

        System.out.println();

        for (int[] m : memo) {
            System.out.println(Arrays.toString(m));
        }
        return memo[N][C];
    }

    public static void main(String[] args) {
        int[] weight = {3, 4, 5};
        int[] value = {4, 5, 6};
        CompleteKnapsack knapsack = new CompleteKnapsack();
        knapsack.knapsackFollowup(weight, value, 10, 3);
    }
}
