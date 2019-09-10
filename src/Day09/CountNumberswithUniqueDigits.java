package Day09;

/**
 * @program: LeetForWork
 * @description: 357. Count Numbers with Unique Digits
 * @author: Zekun Zhang
 * @create: 2019-09-09 14:05
 */

public class CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10;
        int uq = 9;
        int ab = 9;
        while (n-- > 1 && ab > 0) {
            uq = uq * ab;
            res += uq;
            ab--;
        }
        return res;
    }
}
