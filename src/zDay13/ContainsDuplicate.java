package zDay13;

import java.util.HashSet;

/**
 * @program: LeetForWork
 * @description: 217. Contains Duplicate
 * @author: Zekun Zhang
 * @create: 2020-02-27 14:19
 */

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
