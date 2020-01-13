package Day77;

/**
 * @program: LeetForWork
 * @description: 55. Jump Game
 * @author: Zekun Zhang
 * @create: 2020-01-11 14:26
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
