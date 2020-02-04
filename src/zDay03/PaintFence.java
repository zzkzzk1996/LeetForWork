package zDay03;

/**
 * @program: LeetForWork
 * @description: 276. Paint Fence
 * @author: Zekun Zhang
 * @create: 2020-02-04 07:17
 */

public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        int same = 0, diff = k, total = k;
        for (int i = 1; i < n; i++) {
            same = diff;
            diff = (k - 1) * total;
            total = diff + same;
        }
        return total;
    }
}
