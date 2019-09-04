package Day03;

/**
 * @program: LeetForWork
 * @description: 137. Single Number II
 * @author: Zekun Zhang
 * @create: 2019-09-03 21:35
 */

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
