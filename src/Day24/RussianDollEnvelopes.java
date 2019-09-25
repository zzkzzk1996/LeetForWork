package Day24;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description: 354. Russian Doll Envelopes
 * @author: Zekun Zhang
 * @create: 2019-09-24 19:59
 */

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] env : envelopes) {
            int i = binarySearch(dp, 0, res, env[1]);
            dp[i] = env[1];
            if (i == res) res++;
        }
        return res;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        if (nums[start] >= target) return start;
        else return end;
    }
}
