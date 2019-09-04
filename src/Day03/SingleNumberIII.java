package Day03;

/**
 * @program: LeetForWork
 * @description: 260. Single Number III
 * @author: Zekun Zhang
 * @create: 2019-09-03 22:24
 */

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
