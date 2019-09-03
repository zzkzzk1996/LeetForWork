package Day02;

/**
 * @program: LeetForWork
 * @description: 338. Counting Bits
 * @author: Zekun Zhang
 * @create: 2019-09-02 15:08
 */

public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    res[i]++;
                }
                temp >>= 1;
            }
        }
        return res;
    }

    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[(i & (i - 1))] + 1;
        }
        return res;
    }
}
