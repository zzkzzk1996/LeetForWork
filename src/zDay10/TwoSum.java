package zDay10;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 1. Two Sum
 * @author: Zekun Zhang
 * @create: 2020-02-20 13:04
 */

public class TwoSum {
    /**
     * one pass
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No result");
    }

    /**
     * two pass
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[] {map.get(target - nums[i]), i};
            }
        }
        return new int[] {-1, -1};
    }
}
