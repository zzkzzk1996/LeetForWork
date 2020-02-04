package zDay03;

/**
 * @program: LeetForWork
 * @description: 213. House Robber II
 * @author: Zekun Zhang
 * @create: 2020-02-04 05:45
 */

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob (nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0) return 0;
        int preMax = 0, max = 0;
        for (int i = low; i <= high; i++) {
            int temp = max;
            max = Math.max(max, preMax + nums[i]);
            preMax = temp;
        }
        return max;
    }
}
