package Day01;

/**
 * @program: LeetForWork
 * @description: 268. Missing Number: XOR
 * @author: Zekun Zhang
 * @create: 2019-09-01 19:38
 */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^ i;
        }
        return res;
    }
}
