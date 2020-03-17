package zDay23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 417. Pacific Atlantic Water Flow
 * @author: Zekun Zhang
 * @create: 2020-03-16 13:09
 */

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            helper(matrix, pac, i, 0);
            helper(matrix, atl, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            helper(matrix, pac, 0, i);
            helper(matrix, atl, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void helper(int[][] matrix, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : direct) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[0].length || visited[newI][newJ] || matrix[i][j] > matrix[newI][newJ]) continue;
            helper(matrix, visited, newI, newJ);
        }
    }
}
