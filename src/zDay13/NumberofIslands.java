package zDay13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 200. Number of Islands
 * @author: Zekun Zhang
 * @create: 2020-02-27 13:32
 */

public class NumberofIslands {
    /**
     * DFS
     * @param grid
     * @return
     */
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
    }


    /**
     * BFS
     * @param grid
     * @return
     */
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(i * grid[0].length + j);
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        int first = cur / grid[0].length, second = cur % grid[0].length;
                        if (first > 0 && grid[first - 1][second] == '1') {
                            queue.offer((first - 1) * grid[0].length + second);
                            grid[first - 1][second] = '0';
                        }
                        if (first < grid.length - 1 && grid[first + 1][second] == '1') {
                            queue.offer((first + 1) * grid[0].length + second);
                            grid[first + 1][second] = '0';
                        }
                        if (second > 0 && grid[first][second - 1] == '1') {
                            queue.offer(first * grid[0].length + (second - 1));
                            grid[first][second - 1] = '0';
                        }
                        if (second < grid[0].length - 1 && grid[first][second + 1] == '1') {
                            queue.offer(first * grid[0].length + (second + 1));
                            grid[first][second + 1] = '0';
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
