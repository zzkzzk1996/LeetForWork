package Day53;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 216. Combination Sum III
 * @author: Zekun Zhang
 * @create: 2019-10-23 20:09
 */

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n >= k * 9) return res;
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (n < 0) return;
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
            if (i > n) return;
        }
    }
}
