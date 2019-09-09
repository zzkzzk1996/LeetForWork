package Day08;

/**
 * @program: LeetForWork
 * @description: 400. Nth Digit
 * @author: Zekun Zhang
 * @create: 2019-09-08 21:29
 */

public class NthDigit {
    public int findNthDigit(int n) {
        if (n <= 9) return n;
        int len = 1, start = 1;
        long count = 9;
        while (len * count < n) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String t = Integer.toString(start);
        return (t.charAt((n - 1) % len) - '0');
    }
}
