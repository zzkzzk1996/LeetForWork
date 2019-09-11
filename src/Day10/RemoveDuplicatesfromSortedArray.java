package Day10;

/**
 * @program: LeetForWork
 * @description: 26. Remove Duplicates from Sorted Array
 * @author: Zekun Zhang
 * @create: 2019-09-10 20:22
 */

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[res] != nums[i]) {
                res++;
                nums[res] = nums[i];
            }
        }
        return res + 1;
    }
}
