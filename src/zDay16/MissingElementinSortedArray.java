package zDay16;

/**
 * @program: LeetForWork
 * @description: 1060. Missing Element in Sorted Array
 * @author: Zekun Zhang
 * @create: 2020-03-03 15:32
 */

public class MissingElementinSortedArray {
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return 0;
        long compare = nums[0];
        long count = k;
        int i = 0;
        while (i < nums.length) {
            if ((long)nums[i] == compare) {
                i++;
            } else {
                k--;
            }
            if (k == 0) return (int)compare;
            compare++;
        }
        return (int)(compare + k - 1);
    }
}
