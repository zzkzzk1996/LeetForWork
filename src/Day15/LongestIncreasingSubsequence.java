package Day15;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 300. Longest Increasing Subsequence
 * @author: Zekun Zhang
 * @create: 2019-09-15 21:25
 */

//TODO IMPORTANT

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(dp[j], maxval);
                }
            }
            dp[i] = maxval + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;

            while (i != j) {
                int mid = (i + j) / 2;
                if (dp[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }

            dp[i] = num;
            System.out.println(Arrays.toString(dp));
            if (i == res) ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] k = {10,9,2,5,3,7,101,18};
        lengthOfLIS1(k);
    }
}
