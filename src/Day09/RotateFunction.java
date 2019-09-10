package Day09;

/**
 * @program: LeetForWork
 * @description: 396. Rotate Function
 * @author: Zekun Zhang
 * @create: 2019-09-09 18:59
 */

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0, can = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            can += A[i] * i;
        }
        int res = can;
        for (int i = A.length - 1; i >= 0; i--) {
            can = can + sum - A.length * A[i];
            res = Math.max(res, can);
        }
        return res;
    }
}
