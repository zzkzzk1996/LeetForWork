package Day04;

/**
 * @program: LeetForWork
 * @description: 7. Reverse Integer: stack over flow
 * @author: Zekun Zhang
 * @create: 2019-09-04 14:51
 */

public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
        {
            return 0;
        }
        return (int)res;
    }
}
