package Day08;

/**
 * @program: LeetForWork
 * @description: 233. Number of Digit One
 * @author: Zekun Zhang
 * @create: 2019-09-08 19:48
 */

public class NumberofDigitOne {
    public int countDigitOne(int n) {
        int res = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;
            res += (a + 8) / 10 * m;
            if (a % 10 == 1) res += b + 1;
        }
        return res;
    }
}
