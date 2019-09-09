package Day08;

/**
 * @program: LeetForWork
 * @description: 172. Factorial Trailing Zeroes
 * @author: Zekun Zhang
 * @create: 2019-09-08 22:21
 */

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        long fives = 5;
        while (n >= fives) {
            res += n / fives;
            fives *= 5;
        }
        return res;
    }
}
