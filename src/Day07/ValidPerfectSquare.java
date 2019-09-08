package Day07;

/**
 * @program: LeetForWork
 * @description: 367. Valid Perfect Square
 * @author: Zekun Zhang
 * @create: 2019-09-07 20:53
 */

//TODO DIFFMETHOD

public class ValidPerfectSquare {
    public boolean isPerfectSquare1(int num) {
        if (num <= 0) return false;
        int low = 1, high = num;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if (num <= 0) return false;
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    public boolean isPerfectSquare4(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
