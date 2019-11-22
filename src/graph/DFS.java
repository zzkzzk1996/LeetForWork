package graph;

import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-21 21:06
 */

public class DFS {
    public static void dfs(List<GraphNode> list) {
        HashSet<GraphNode> visited = new HashSet<>();
        for (GraphNode node : list) {
            if (!visited.contains(node)) {
                helper(node, visited);
            }
        }
    }

    public static void dfs1(GraphNode node) {
        helper(node, new HashSet<>());
    }

    private static void helper(GraphNode node, HashSet<GraphNode> visited) {
        visited.add(node);
        for (GraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                helper(neighbor, visited);
            }
        }
    }

    public static void dfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                helper(matrix, visited, i);
            }
        }
    }

    private static void helper(int[][] matrix, int[] visited, int vertex) {
        visited[vertex] = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] == 1) {
                if (visited[i] == 0) {
                    helper(matrix, visited, i);
                }
            }
        }
    }
}
