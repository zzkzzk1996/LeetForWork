package Day12;

/**
 * @program: LeetForWork
 * @description: 209. Minimum Size Subarray Sum
 * @author: Zekun Zhang
 * @create: 2019-09-12 17:38
 */

//TODO MAYBE BINARY SEARCH

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s < 1) return 0;
        int sum = 0, start = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (start <= i && sum >= s) {
                res = Math.min(res, i - start + 1);
                sum -= nums[start++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
