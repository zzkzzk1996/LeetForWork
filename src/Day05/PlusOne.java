package Day05;

/**
 * @program: LeetForWork
 * @description: 66. Plus One
 * @author: Zekun Zhang
 * @create: 2019-09-05 22:06
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
