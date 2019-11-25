package unionFind;

public interface MyUnionFind {
    /**
     * count nodes
     * @return
     */
    int count();

    /**
     * union two nodes
     * @param x
     * @param y
     */
    void union(int x, int y);

    /**
     * find the collection
     * @param index
     * @return
     */
    int find(int index);

    /**
     * determine connected or not
     * @param x
     * @param y
     * @return
     */
    boolean connected(int x, int y);
}
