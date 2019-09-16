package Day15;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 164. Maximum Gap
 * @author: Zekun Zhang
 * @create: 2019-09-15 22:15
 */

//TODO REPEAT

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int len = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int gap = (int)Math.ceil((double)(max - min) / (len - 1));
        int[] bucketMin = new int[len - 1];
        int[] bucketMax = new int[len - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) continue;
            int bucket = (num - min) / gap;
            bucketMin[bucket] = Math.min(bucketMin[bucket], num);
            bucketMax[bucket] = Math.max(bucketMax[bucket], num);
        }

        int res = 0;
        int pre = min;
        for (int i = 0; i < len - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;
            res = Math.max(res, bucketMin[i] - pre);
            pre = bucketMax[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}
