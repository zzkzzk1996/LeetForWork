package Day08;

/**
 * @program: LeetForWork
 * @description: 372. Super Pow
 * @author: Zekun Zhang
 * @create: 2019-09-08 19:28
 */

//TODO MISUNDERSTANDING

public class SuperPow {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }
    private int superPow(int a, int[] b, int len, int k) {
        if (len == 1) return myPow(a, b[0], k);
        int nextBit = superPow(a, b, len - 1, k);
        int thisBit = myPow(a, b[len - 1], k);
        return myPow(nextBit, 10, k) * thisBit % k;
    }

    public int superPow1(int a, int[] b) {
        int k = 1337;
        a %= k;
        int res = 1;
        for (int i : b) {
            res = myPow(res, 10, k) * myPow(a, i, k) % k;
        }
        return res;
    }
    private int myPow(int x, int y, int k) {
        x %= k;
        int pow = 1;
        for (int i = 0; i < y; i++) {
            pow = pow * x % k;
        }
        return pow;
    }
}
