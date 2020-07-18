package Day52;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 77. Combinations
 * @author: Zekun Zhang
 * @create: 2019-10-22 19:44
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
