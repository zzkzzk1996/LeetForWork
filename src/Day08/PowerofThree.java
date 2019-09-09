package Day08;

/**
 * @program: LeetForWork
 * @description: 326. Power of Three
 * @author: Zekun Zhang
 * @create: 2019-09-08 15:58
 */

public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
    public boolean isPowerOfThree1(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
