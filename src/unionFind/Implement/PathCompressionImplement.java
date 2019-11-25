package unionFind.Implement;

import unionFind.MyUnionFind;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-25 14:15
 */

public class PathCompressionImplement implements MyUnionFind {
    int count;

    private int[] parents;

    private int[] rank;

    public PathCompressionImplement(int count) {
        this.count = count;
        this.parents = new int[count];
        this.rank = new int[count];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) {
        int ARoot = find(x);
        int BRoot = find(y);
        if (ARoot == BRoot) return;

        if (rank[ARoot] < rank[BRoot]) {
            parents[ARoot] = BRoot;
        } else if (rank[ARoot] > rank[BRoot]){
            parents[BRoot] = ARoot;
        } else {
            parents[BRoot] = ARoot;
            rank[ARoot]++;
        }

    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return parents[index];
    }

    public int find2(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        if (index != parents[index]) {
            index = find2(parents[index]);
        }
        return parents[index];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
