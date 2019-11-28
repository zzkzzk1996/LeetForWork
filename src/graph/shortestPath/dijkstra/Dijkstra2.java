package graph.shortestPath.dijkstra;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-27 21:30
 */

public class Dijkstra2 {

    public void dijkstra(int[][] matrix) {

        int vertices = matrix.length;
        boolean[] visited = new boolean[vertices];
        int[] minDist = new int[vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        for (int i = 0; i < vertices; i++) {
            int vertex = getMinVertex(visited, minDist);
            visited[vertex] = true;
            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && matrix[vertex][j] != 0) {
                    int curDist = minDist[vertex] + matrix[vertex][j];
                    if (curDist < minDist[j]) {
                        minDist[j] = curDist;
                    }
                }
            }
        }
        print(minDist);
    }

    public void print(int[] minDist) {
        for (int i = 0; i < minDist.length; i++) {
            System.out.println("Vertex 0 : " + " - " + i + " minDist : " + minDist[i]);
        }
    }

    private int getMinVertex(boolean[] visited, int[] minDist) {
        int min = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < minDist.length; i++) {
            if (!visited[i] && minDist[i] < min) {
                min = minDist[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 4, 3, 0, 0, 0},
                {4, 0, 1, 2, 0, 0},
                {3, 1, 0, 4, 3, 0},
                {0, 2, 4, 0, 2, 1},
                {0, 0, 3, 2, 0, 6},
                {0, 0, 0, 1, 6, 0}
        };
        Dijkstra2 dijkstra2 = new Dijkstra2();
        dijkstra2.dijkstra(matrix);
    }
}
