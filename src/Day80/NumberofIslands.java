package Day80;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 200. Number of Islands
 * @author: Zekun Zhang
 * @create: 2020-01-16 11:12
 */

public class NumberofIslands {
    //Naive BFS
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Pair<>(i, j))) {
                    res++;
                    queue.offer(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        Pair cur = queue.poll();
                        if (!visited.contains(cur)) {
                            visited.add(cur);
                            int I = (int) cur.getKey();
                            int J = (int) cur.getValue();
                            if (J + 1 < grid[0].length && grid[I][J + 1] == '1') {
                                queue.offer(new Pair<>(I, J + 1));
                            }
                            if (J - 1 >= 0 && grid[I][J - 1] == '1') {
                                queue.offer(new Pair<>(I, J - 1));
                            }
                            if (I + 1 < grid.length && grid[I + 1][J] == '1') {
                                queue.offer(new Pair<>(I + 1, J));
                            }
                            if (I - 1 >= 0 && grid[I - 1][J] == '1') {
                                queue.offer(new Pair<>(I - 1, J));
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    //Naive DFS
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, m, n, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void helper(char[][] grid, int m, int n, int i, int j) {
        grid[i][j] = '0';
        if (j + 1 < n && grid[i][j + 1] == '1') {
            helper(grid, m, n, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            helper(grid, m, n, i, j - 1);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            helper(grid, m, n, i - 1, j);
        }
        if (i + 1 < m && grid[i + 1][j] == '1') {
            helper(grid, m, n, i + 1, j);
        }
    }
}
