package Day15;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 1218. Longest Arithmetic Subsequence of Given Difference
 * @author: Zekun Zhang
 * @create: 2019-10-10 23:29
 */

public class LongestArithmeticSubsequenceofGivenDifference {
    // Time excess limit
    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length == 0) return 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + difference == arr[j]) {
                    dp[j] = dp[i] + 1;
                }
                maxLen = Math.max(dp[j], maxLen);
            }
        }
        return maxLen;
    }

    public int longestSubsequence1(int[] arr, int difference) {
        if (arr == null || arr.length == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i], pre = value - difference;
            map.put(value, map.getOrDefault(pre, 0) + 1);
            maxLen = Math.max(maxLen, map.get(value));
        }
        return maxLen;
    }

}
