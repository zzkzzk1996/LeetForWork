package Day14;

/**
 * @program: LeetForWork
 * @description: 287. Find the Duplicate Number
 * @author: Zekun Zhang
 * @create: 2019-09-15 00:33
 */

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = nums[0], fast = nums[0], slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        while (slow != res) {
            slow = nums[slow];
            res = nums[res];
        }
        return res;
    }
}
