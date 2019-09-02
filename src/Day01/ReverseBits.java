package Day01;

/**
 * @program: LeetForWork
 * @description: 190. Reverse Bits: n & 1
 * @author: Zekun Zhang
 * @create: 2019-09-01 20:24
 */

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;
    }
}
