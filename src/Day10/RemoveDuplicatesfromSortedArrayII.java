package Day10;

/**
 * @program: LeetForWork
 * @description: 80. Remove Duplicates from Sorted Array II
 * @author: Zekun Zhang
 * @create: 2019-09-10 20:31
 */

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[res] == nums[i] && ((res == 0) || (nums[res - 1] != nums[res]))) {
                nums[++res] = nums[i];
            } else if (nums[res] != nums[i]) {
                nums[++res] = nums[i];
            }
        }
        return res + 1;
    }
}
