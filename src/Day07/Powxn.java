package Day07;

/**
 * @program: LeetForWork
 * @description: 50. Pow(x, n)
 * @author: Zekun Zhang
 * @create: 2019-09-07 20:38
 */

//TODO REDO

public class Powxn {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
        }
        long abs = Math.abs((long)n);
        double res = 1;
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        return res;
    }

    public double myPow1(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1 / pow(x, n);
        }
    }
    private double pow(double x, int n) {
        if (n == 0) return 1;
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}
