package zDay15;

/**
 * @program: LeetForWork
 * @description: 1209. Remove All Adjacent Duplicates in String II
 * @author: Zekun Zhang
 * @create: 2020-03-02 18:14
 */

public class RemoveAllAdjacentDuplicatesinStringII {
    public String removeDuplicates1(String s, int k) {
        if (s == null || s.length() == 0 || k < 2) return "";
        StringBuilder str = new StringBuilder(s);
        int len = -1;
        while (len != str.length()) {
            len = str.length();
            for (int i = 0, count = 1; i < str.length(); i++) {
                if (i == 0 || str.charAt(i - 1) != str.charAt(i)) count = 1;
                else if (++count == k){
                    str.delete(i - k + 1, i + 1);
                    break;
                }
            }
        }
        return str.toString();
    }

    public String removeDuplicates2(String s, int k) {
        if (s == null || s.length() == 0 || k < 2) return "";
        StringBuilder str = new StringBuilder(s);
        int len = -1;
        int[] count = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i - 1) != str.charAt(i)) count[i] = 1;
            else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    str.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }

        return str.toString();
    }
}
