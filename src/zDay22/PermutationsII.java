package zDay22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 47. Permutations II
 * @author: Zekun Zhang
 * @create: 2020-03-15 14:00
 */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(res, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
