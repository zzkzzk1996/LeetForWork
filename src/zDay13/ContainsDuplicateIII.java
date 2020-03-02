package zDay13;

import java.util.TreeSet;

/**
 * @program: LeetForWork
 * @description: 220. Contains Duplicate III
 * @author: Zekun Zhang
 * @create: 2020-02-27 14:32
 */

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < Math.min(i + 1 + k, nums.length); j++) {
                long diff = Math.abs((long)nums[i] - (long)nums[j]);
                long lt = (long)t;
                if (diff <= lt) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i] + t);
            Long ceiling = set.ceiling((long)nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) return true;
            set.add((long)nums[i]);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
