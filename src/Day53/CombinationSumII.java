package Day53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 40. Combination Sum II
 * @author: Zekun Zhang
 * @create: 2019-10-23 19:58
 */

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] can, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < can.length; i++) {
            if (i != start && can[i] == can[i - 1]) continue;
            list.add(can[i]);
            helper(res, list, can, target - can[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
