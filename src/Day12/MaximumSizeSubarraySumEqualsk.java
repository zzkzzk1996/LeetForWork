package Day12;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 325. Maximum Size Subarray Sum Equals k
 * @author: Zekun Zhang
 * @create: 2019-09-12 17:18
 */

public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        long[] sums = new long[nums.length];
        HashMap<Long, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        sums[0] = nums[0];
        map.put((long)0, -1);
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }

        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(sums[j] - k)) {
                maxLen = Math.max(maxLen, j - map.get(sums[j] - k));
            }
            if (!map.containsKey(sums[j])) {
                map.put(sums[j], j);
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
