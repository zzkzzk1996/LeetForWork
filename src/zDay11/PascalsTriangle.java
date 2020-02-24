package zDay11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 118. Pascal's Triangle
 * @author: Zekun Zhang
 * @create: 2020-02-23 19:31
 */

public class PascalsTriangle {
    public List<List<Integer>> generate1(int numRows) {
        if (numRows < 1) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int[] dp = new int[numRows + 1];
        dp[1] = 1;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            int temp = dp[1];
            for (int j = 1; j < i + 1; j++) {
                if (j == i) {
                    dp[j - 1] = temp;
                    dp[j] = 1;
                    list.add(dp[j]);
                    continue;
                }
                if (j > 1) {
                    int change = dp[j - 1] + dp[j];
                    list.add(change);
                    dp[j - 1] = temp;
                    temp = change;
                } else {
                    list.add(dp[1]);
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        if (numRows < 1) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> pre = res.get(i - 1);
            int lastNum = 0;
            for (Integer num : pre) {
                if (list.size() != 0) {
                    list.add(num + lastNum);
                } else {
                    list.add(num);
                }
                lastNum = num;
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
