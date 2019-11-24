package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

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

    public static void dfsIteration(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();
        stack.push(node);
        visited.add(node);
        while (!stack.isEmpty()) {
            GraphNode cur = stack.pop();
            for (GraphNode neighbor : cur.neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
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

    public static void dfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer vertex = stack.pop();
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                visited[j] = 1;
                                stack.push(j);
                            }
                        }
                    }
                }
            }
        }
    }
}
