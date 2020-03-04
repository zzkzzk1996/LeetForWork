package zDay16;

/**
 * @program: LeetForWork
 * @description: 1047. Remove All Adjacent Duplicates In String
 * @author: Zekun Zhang
 * @create: 2020-03-03 16:09
 */

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        if (S == null || S.length() < 2) return S;
        StringBuilder str = new StringBuilder(S);
        int len = 0;
        while (len != str.length()) {
            len = str.length();
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    str.delete(i - 1, i + 1);
                    if (i != 1) i -= 2;
                }
            }
        }

        return str.toString();
    }
}
