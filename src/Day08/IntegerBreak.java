package Day08;

/**
 * @program: LeetForWork
 * @description: 343. Integer Break
 * @author: Zekun Zhang
 * @create: 2019-09-08 22:36
 */

//TODO CONSIDERING DP

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
