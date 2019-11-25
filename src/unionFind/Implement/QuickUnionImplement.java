package unionFind.Implement;

import unionFind.MyUnionFind;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-25 14:15
 */

public class QuickUnionImplement implements MyUnionFind {
    int count;

    private int[] parents;
    public QuickUnionImplement(int count) {
        this.count = count;
        parents = new int[count];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
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

        parents[ARoot] = BRoot;
    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        while (index != parents[index]) {
            index = parents[index];
        }
        return parents[index];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
