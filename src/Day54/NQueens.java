package Day54;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 51. N-Queens
 * @author: Zekun Zhang
 * @create: 2019-10-24 23:14
 */

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) return res;
        helper(res, new int[n], 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] queens, int pos) {
        if (pos == queens.length) {
            addSolution(res, queens);
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            queens[pos] = i;
            if (isValid(queens, pos)) {
                helper(res, queens, pos + 1);
            }
        }
    }

    private boolean isValid(int[] queens, int pos) {
        for (int i = 0; i < pos; i++) {
            if (queens[i] == queens[pos]) {
                return false;
            } else if (Math.abs(queens[i] - queens[pos]) == Math.abs(i - pos)) {
                return false;
            }
        }
        return true;
    }

    private void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
