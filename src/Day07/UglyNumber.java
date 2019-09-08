package Day07;

/**
 * @program: LeetForWork
 * @description: 263. Ugly Number
 * @author: Zekun Zhang
 * @create: 2019-09-07 22:08
 */

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}
