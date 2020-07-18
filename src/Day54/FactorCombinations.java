package Day54;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 254. Factor Combinations
 * @author: Zekun Zhang
 * @create: 2019-10-24 20:07
 */

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2) return res;
        helper(res, new ArrayList<>(), 2, n);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int start, int n) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(res, list, i, n / i);
                list.remove(list.size() - 1);
            }
        }
    }
}
