package Day58;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 282. Expression Add Operators
 * @author: Zekun Zhang
 * @create: 2019-10-28 16:02
 */

public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, num, target, "", 0, 0, 0);
        return res;
    }

    private static void helper(List<String> res, String num, int target, String cur, int index, long val, long pre) {
        if (index == num.length()) {
            if (val == target) {
                res.add(cur);
                return;
            }
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;
            long temp = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(res, num, target, cur + temp, i + 1, temp, temp);
            } else {
                helper(res, num, target, cur + "+" + temp, i + 1, val + temp, temp);
                helper(res, num, target, cur + "-" + temp, i + 1, val - temp, -temp);
                helper(res, num, target, cur + "*" + temp, i + 1, val - pre + pre * temp, pre * temp);
            }
        }
    }
}
