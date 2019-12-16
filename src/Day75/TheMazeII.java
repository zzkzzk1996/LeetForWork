package Day75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 505. The Maze II
 * @author: Zekun Zhang
 * @create: 2019-12-13 18:17
 */

public class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return -1;
        }
        int[][] directions = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int sum = distance[cur[0]][cur[1]];
            for (int[] direction : directions) {
                int i = cur[0];
                int j = cur[1];
                int temp = 0;
                while (!isWall(i + direction[0], j + direction[1], maze)) {
                    i += direction[0];
                    j += direction[1];
                    temp += 1;
                }
                if (distance[i][j] > sum + temp) {
                    distance[i][j] = Math.min(distance[i][j], sum + temp);
                    queue.offer(new int[] {i, j});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private boolean isWall(int i, int j, int[][] maze) {
        int row = maze.length;
        int col =  maze[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || maze[i][j] == 1) return true;
        return false;
    }
}
