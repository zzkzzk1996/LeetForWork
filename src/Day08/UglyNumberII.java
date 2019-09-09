package Day08;

/**
 * @program: LeetForWork
 * @description: 264. Ugly Number II
 * @author: Zekun Zhang
 * @create: 2019-09-08 15:52
 */

//TODO REMEMBER

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] ugly = new int[n + 1];
        ugly[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            if (ugly[i] == ugly[i2] * 2) i2++;
            if (ugly[i] == ugly[i3] * 3) i3++;
            if (ugly[i] == ugly[i5] * 5) i5++;
        }
        return ugly[n];
    }
}
