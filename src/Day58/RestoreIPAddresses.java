package Day58;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 93. Restore IP Addresses
 * @author: Zekun Zhang
 * @create: 2019-10-28 15:21
 */

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, "", 0, 0);
        return res;
    }

    private static void helper(List<String> res, String s, String cur, int index, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            res.add(cur);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if ((temp.startsWith("0") && temp.length() > 1) || (i == 3 && Integer.parseInt(temp) >= 256)) break;
            helper(res, s, cur + temp + (count == 3 ? "" : "."), index + i, count + 1);
        }
    }
}
