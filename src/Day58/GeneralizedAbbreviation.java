package Day58;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 320. Generalized Abbreviation
 * @author: Zekun Zhang
 * @create: 2019-10-28 14:54
 */

public class GeneralizedAbbreviation {
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, "", word, 0, 0);
        return res;
    }
    private static void helper(List<String> res, String temp, String word, int len, int pos) {
        if (pos == word.length()) {
            if (len > 0) temp += len;
            res.add(temp);
        } else {
            helper(res, temp, word, len + 1, pos + 1);
            helper(res, temp + (len > 0 ? len : "") + word.charAt(pos), word, 0, pos + 1);
        }
    }
}
