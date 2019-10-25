package Day53;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 39. Combination Sum
 * @author: Zekun Zhang
 * @create: 2019-10-23 19:48
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] can, int target, int sum, int start) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < can.length; i++) {
            list.add(can[i]);
            sum += can[i];
            helper(res, list, can, target, sum, i);
            list.remove(list.size() - 1);
            sum -= can[i];
        }
    }
}
