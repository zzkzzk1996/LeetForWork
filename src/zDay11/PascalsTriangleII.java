package zDay11;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 119. Pascal's Triangle II
 * @author: Zekun Zhang
 * @create: 2020-02-23 19:37
 */

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int val = res.get(0);
            for (int j = 1; j < i; j++) {
                int temp = res.get(j - 1) + res.get(j);
                res.set(j - 1, val);
                val = temp;
            }
            res.set(res.size() - 1, val);
            res.add(1);
        }
        return res;
    }
}
