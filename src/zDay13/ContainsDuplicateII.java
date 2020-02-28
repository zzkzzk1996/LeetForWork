package zDay13;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 219. Contains Duplicate II
 * @author: Zekun Zhang
 * @create: 2020-02-27 14:32
 */

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
