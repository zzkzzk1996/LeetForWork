package graph;

import com.sun.jdi.connect.spi.TransportService;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-24 18:40
 */

public class BFS {
    public static void bfs(GraphNode graphNode) {
        Queue<GraphNode> queue = new LinkedList<>();
        HashSet<GraphNode> visited = new HashSet<>();

        queue.offer(graphNode);
        visited.add(graphNode);

        while (!visited.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = queue.poll();
                for (GraphNode neighbor : node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    public static void bfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        Integer vertex = queue.poll();
                        for (int j = 0; j < visited.length; j++) {
                            if (matrix[vertex][j] == 1) {
                                if (visited[j] == 0) {
                                    queue.offer(j);
                                    visited[j] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
