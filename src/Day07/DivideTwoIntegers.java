package Day07;

/**
 * @program: LeetForWork
 * @description: 29. Divide Two Integers
 * @author: Zekun Zhang
 * @create: 2019-09-07 11:10
 */

//TODO Important

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldividend < ldivisor || ldivisor == 0) return 0;
        long lres = ldivide(ldividend, ldivisor);
        int res = 0;
        if (lres >= Integer.MAX_VALUE) {
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            res = ((int)lres) * sign;
        }
        return res;

    }
    private static long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long mul = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            mul += mul;
        }
        return mul + ldivide(ldividend - sum, ldivisor);
    }
    public static void main(String[] args) {
        divide(-2147483648,-1);
    }
}
