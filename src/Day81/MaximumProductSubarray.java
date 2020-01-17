package Day81;

/**
 * @program: LeetForWork
 * @description: 152. Maximum Product Subarray
 * @author: Zekun Zhang
 * @create: 2020-01-16 11:53
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
