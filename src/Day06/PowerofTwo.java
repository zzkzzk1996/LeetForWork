package Day06;

/**
 * @program: LeetForWork
 * @description: 231. Power of Two
 * @author: Zekun Zhang
 * @create: 2019-09-06 09:52
 */

public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
