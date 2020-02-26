package zDay12;

import java.util.HashSet;

/**
 * @program: LeetForWork
 * @description: 128. Longest Consecutive Sequence
 * @author: Zekun Zhang
 * @create: 2020-02-25 18:02
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int streak = 1;
                int cur = num;
                while (set.contains(cur + 1)) {
                    cur++;
                    streak++;
                }
                res = Math.max(streak, res);
            }
        }
        return res;
    }
}
