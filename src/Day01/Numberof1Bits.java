package Day01;

/**
 * @program: LeetForWork
 * @description: 191. Number of 1 Bits: n & 1 ----- n & n - 1
 * @author: Zekun Zhang
 * @create: 2019-09-01 19:47
 */

public class Numberof1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public int hamingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }


}
