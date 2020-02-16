package zDay07;

/**
 * @program: LeetForWork
 * @description: 330. Patching Array
 * @author: Zekun Zhang
 * @create: 2020-02-13 12:33
 */

/**
 * Hard and important
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        int i = 0, res = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
            } else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
