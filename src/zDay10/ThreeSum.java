package zDay10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 15. 3Sum
 * @author: Zekun Zhang
 * @create: 2020-02-20 17:42
 */

public class ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];

                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[start], nums[end]);
                    set.add(list);
                }

                if (sum > 0) end--;
                else start++;
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                } else if (sum > 0) end--;
                else start++;

            }
        }
        return res;
    }
}
