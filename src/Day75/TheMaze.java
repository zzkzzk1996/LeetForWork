package Day75;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 490. The Maze
 * @author: Zekun Zhang
 * @create: 2019-12-13 18:16
 */

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return false;
        }
        int[][] directions = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;
            for (int[] direction : directions) {
                int i = cur[0];
                int j = cur[1];
                while (!isWall(i + direction[0], j + direction[1], maze)) {
                    i += direction[0];
                    j += direction[1];
                }
                if (i == destination[0] && j == destination[1]) return true;
                if (!visited[i][j]) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        return false;
    }

    private boolean isWall(int i, int j, int[][] maze) {
        int row = maze.length;
        int col =  maze[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || maze[i][j] == 1) return true;
        return false;
    }
}
