package Day07;

/**
 * @program: LeetForWork
 * @description: 69. Sqrt(x)
 * @author: Zekun Zhang
 * @create: 2019-09-07 17:03
 */

//TODO CAUTION: STACKOVERFLOW

public class Sqrtx {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int high = x, low = 1;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        if (high * high < x) {
            return (int)high;
        } else {
            return (int)low;
        }
    }

    public int mySqrt1(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}
