package zDay10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 18. 4Sum
 * @author: Zekun Zhang
 * @create: 2020-02-20 19:06
 */

public class FourSum {
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>();
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                    }

                    if (sum < target) start++;
                    else if (sum > target) end--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                int start = j + 1, end = nums.length - 1;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while (start < end) {
                    int sum = nums[start] + nums[end] + nums[i] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (sum > target) end--;
                    else start++;
                }
            }
        }
        return res;
    }
}
