package Day75;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 499. The Maze III
 * @author: Zekun Zhang
 * @create: 2019-12-13 18:59
 */

public class TheMazeIII {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return "impossible";
        }
        int[][] directions = new int[][] {{1, 0, 0}, {0, -1, 1}, {-1, 0, 2}, {0, 1, 3}};
        String[] mappings = new String[] {"d", "l", "u", "r"};
        int[][] distances = new int[maze.length][maze[0].length];
        List<String> res = new ArrayList<>();
        for (int[] rows : distances) {
            Arrays.fill(rows, Integer.MAX_VALUE);
        }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(ball[0], ball[1], ""));
        distances[ball[0]][ball[1]] = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] direction : directions) {
                int i = cur.i;
                int j = cur.j;
                int temp = 0;
                String path = "";
                while (!isWall(maze, i + direction[0], j + direction[1])) {
                    path += mappings[direction[2]];
                    i += direction[0];
                    j += direction[1];
                    temp += 1;
                    if (i == hole[0] && j == hole[1]) {
                        if (distances[cur.i][cur.j] + temp < distances[i][j]) {
                            res.clear();
                            res.add(cur.path + path);
                        } else if (distances[cur.i][cur.j] + temp == distances[i][j]) {
                            res.add(cur.path + path);
                        }
                    }
                }
                if (distances[cur.i][cur.j] + temp <= distances[i][j]) {
                    distances[i][j] = Math.min(distances[i][j], distances[cur.i][cur.j] + temp);
                    queue.offer(new Point (i, j, cur.path + path));
                }
            }
        }
        if (res.size() == 0) return "impossible";
        String result = res.get(0);
        for (int k = 1; k < res.size(); k++) {
            if (result.compareTo(res.get(k)) >= 0) {
                result = res.get(k);
            }
        }
        return result;
    }

    private boolean isWall(int[][] maze, int i, int j) {
        int row = maze.length;
        int col =  maze[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || maze[i][j] == 1) return true;
        return false;
    }

    class Point {
        public int i;
        public int j;
        public String path;
        Point(int i, int j, String path) {
            this.i = i;
            this.j = j;
            this.path = path;
        }
    }
}
