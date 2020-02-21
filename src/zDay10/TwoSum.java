package zDay10;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 1. Two Sum
 * @author: Zekun Zhang
 * @create: 2020-02-20 13:04
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No result");
    }
}
