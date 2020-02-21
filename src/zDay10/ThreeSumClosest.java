package zDay10;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 16. 3Sum Closest
 * @author: Zekun Zhang
 * @create: 2020-02-20 18:19
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) return target;
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    res = sum;
                }
                if (sum < target) start++;
                else end--;
            }
        }
        return res;
    }
}
