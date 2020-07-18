package Day55;

/**
 * @program: LeetForWork
 * @description: 52. N-Queens II
 * @author: Zekun Zhang
 * @create: 2019-10-25 17:07
 */

public class NQueensII {
    private int res = 0;
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[n * 2];
        boolean[] d2 = new boolean[n * 2];
        helper(0, d1, d2, cols, n);
        return res;
    }

    private void helper(int row, boolean[] d1, boolean[] d2, boolean[] cols, int n) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            cols[col] = true; d1[id1] = true; d2[id2] = true;
            helper(row + 1, d1, d2, cols, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}
