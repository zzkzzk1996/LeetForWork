package Day51;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 78. Subsets
 * @author: Zekun Zhang
 * @create: 2019-10-21 11:22
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
