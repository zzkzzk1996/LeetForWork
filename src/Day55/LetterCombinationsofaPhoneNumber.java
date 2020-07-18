package Day55;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 17. Letter Combinations of a Phone Number
 * @author: Zekun Zhang
 * @create: 2019-10-25 17:21
 */

public class LetterCombinationsofaPhoneNumber {
    private String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(res, digits, 0, "");
        return res;
    }

    private void helper(List<String> res, String digits, int pos, String com) {
        if (com.length() == digits.length()) {
            res.add(com);
            return;
        }
        String key = mapping[digits.charAt(pos) - '0'];
        for (int j = 0; j < key.length(); j++) {
            helper(res, digits, pos + 1, com + key.charAt(j));
        }
    }
}
