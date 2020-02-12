package zDay06;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 45. Jump Game II
 * @author: Zekun Zhang
 * @create: 2020-02-12 15:43
 */

public class JumpGameII {
    /* O(n) ~ O(n^2) */
    public int jump1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int maxStep = Math.min(nums[i] + i, nums.length - 1);
            for (int j = i + 1; j <= maxStep; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    /* O(n) */
    public int jump2(int[] nums) {

//        if (nums == null || nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        int maxStep = nums[0], lastMax = nums[0], minVal = 1;
//        for (int i = 1; i < nums.length; i++) {
//            maxStep = Math.max(maxStep, nums[i] + i);
//            if (i < lastMax) {
//                dp[i] = minVal;
//            } else if (i == lastMax) {
//                dp[i] = minVal;
//                lastMax = maxStep;
//                minVal += 1;
//            }
//        }
//        return dp[nums.length - 1];


//        if (nums == null || nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        int maxStep = nums[0], lastMax = nums[0], minVal = 1;
//        for (int i = 1; i < nums.length; i++) {
//            maxStep = Math.max(maxStep, nums[i] + i);
//            dp[i] = minVal;
//            if (i == lastMax) {
//                lastMax = maxStep;
//                minVal += 1;
//            }
//        }
//        return dp[nums.length - 1];

        if (nums == null || nums.length < 2) return 0;
        /**
         * maxStep means the farthest position you can get to
         * lastMax means the farthest position you can get to with the min step now
         * minVal means the minimum steps it would take right now
         */
        int maxStep = nums[0], lastMax = nums[0], minVal = 1;
        for (int i = 1; i < nums.length; i++) {
            maxStep = Math.max(maxStep, nums[i] + i);
            if (i == lastMax && i != nums.length - 1) {
                lastMax = maxStep;
                minVal += 1;
            }
        }
        return minVal;
    }

    /**
     * bfs
     * @param nums
     * @return
     */
    public int jump3(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int maxStep = 0, lastMax = 0, minVal = 0, i = 0;
        while (lastMax - i + 1 > 0) {
            minVal++;
            for(; i <= lastMax; i++) {
                maxStep = Math.max(maxStep, nums[i] + i);
                if (maxStep >= nums.length - 1) return minVal;
            }
            lastMax = maxStep;
        }
        return 0;
    }
}
