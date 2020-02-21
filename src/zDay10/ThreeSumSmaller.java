package zDay10;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 259. 3Sum Smaller
 * @author: Zekun Zhang
 * @create: 2020-02-20 18:33
 */

public class ThreeSumSmaller {
    public int threeSumSmaller1(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                while (sum >= target && start < end) {
                    sum = nums[i] + nums[start] + nums[--end];
                }
                while (start < end && sum < target) {
                    res += end - start;
                    sum = nums[i] + nums[++start] + nums[end];
                }
            }
        }
        return res;
    }

    public int threeSumSmaller2(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    res += end - start;
                    start++;
                } else end--;
            }
        }
        return res;
    }
}
