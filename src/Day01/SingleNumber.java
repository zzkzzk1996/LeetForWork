package Day01;

/**
 * @program: LeetForWork
 * @description: 136. Single Number: XOR
 * @author: Zekun Zhang
 * @create: 2019-09-01 19:28
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
