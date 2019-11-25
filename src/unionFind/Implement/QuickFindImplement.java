package unionFind.Implement;

import unionFind.MyUnionFind;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-25 14:01
 */

public class QuickFindImplement implements MyUnionFind {

    int count;

    private int[] id;
    public QuickFindImplement(int count) {
        this.count = count;
        id = new int[count];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) {
        int A = find(x);
        int B = find(y);
        if (A == B) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == A) {
                id[i] = B;
            }
        }
    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return id[index];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
