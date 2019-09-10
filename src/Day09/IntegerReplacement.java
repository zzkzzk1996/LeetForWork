package Day09;

/**
 * @program: LeetForWork
 * @description: 397. Integer Replacement
 * @author: Zekun Zhang
 * @create: 2019-09-09 15:31
 */

public class IntegerReplacement {
    public int integerReplacement(int n) {
        int res = 0;
        long N = n;
        while (N != 1) {
            if ((N & 1) == 0) {
                N /= 2;
                res++;
            } else {
                if (N == 3) {
                    res += 2;
                    break;
                }
                N = (N & 2) == 2 ? N + 1 : N - 1;
                res++;
            }
        }
        return res;
    }

    public int integerReplacement1(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int res = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n /= 2;
                res++;
            } else {
                if (n == 3) {
                    res += 2;
                    break;
                }
                int temp = (n - 1) / 2;
                if ((temp & 1) == 0) {
                    n = n - 1;
                } else {
                    n = n + 1;
                }
                res++;
            }
        }
        return res;
    }
}
