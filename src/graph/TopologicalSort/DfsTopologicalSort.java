package graph.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-24 21:54
 */

public class DfsTopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int next = pair[0];
            int prev = pair[1];
            graph.get(prev).add(next);
        }
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            visited.put(i, 0);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.get(i) == 0) {
                if (!helper(graph, visited, res, i)) {
                    return new int[0];
                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }

    private boolean helper(List<List<Integer>> graph, HashMap<Integer, Integer> visited, List<Integer> res, int i) {
        if (visited.get(i) == 2) return true;
        if (visited.get(i) == 1) return false;
        visited.put(i, 1);
        for (int j : graph.get(i)) {
            if (!helper(graph, visited, res, j)) {
                return false;
            }
        }
        visited.put(i, 2);
        res.add(i);
        return true;
    }
}
