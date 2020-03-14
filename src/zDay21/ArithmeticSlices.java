package zDay21;

/**
 * @program: LeetForWork
 * @description: 413. Arithmetic Slices
 * @author: Zekun Zhang
 * @create: 2020-03-12 20:37
 */

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int res = 0, streak = 0, diff = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == diff) {
                streak++;
                res += streak;
            } else {
                streak = 0;
                diff = A[i] - A[i - 1];
            }
        }
        return res;
    }
}
