package Day02;

/**
 * @program: LeetForWork
 * @description: 371. Sum of Two Integers
 * @author: Zekun Zhang
 * @create: 2019-09-02 14:44
 */

public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }
}
