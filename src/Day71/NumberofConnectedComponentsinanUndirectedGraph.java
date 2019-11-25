package Day71;

/**
 * @program: LeetForWork
 * @description: 323. Number of Connected Components in an Undirected Graph
 * @author: Zekun Zhang
 * @create: 2019-11-25 16:20
 */

public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int res = n;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] pair : edges) {
            int xRoot = find(parents, pair[0]);
            int yRoot = find(parents, pair[1]);
            if (xRoot != yRoot) {
                parents[xRoot] = yRoot;
                res--;
            }
        }

        return res;
    }

    private int find(int[] parents, int index) {
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }
}
