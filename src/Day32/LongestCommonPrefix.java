package Day32;

/**
 * @program: LeetForWork
 * @description: 14. Longest Common Prefix
 * @author: Zekun Zhang
 * @create: 2019-10-02 23:33
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String t = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            for (int j = 0; j <= Math.min(t.length(), s.length()); j++) {
                if (j == Math.min(t.length(), s.length()) || t.charAt(j) != s.charAt(j)) {
                    t = t.substring(0, j);
                    break;
                }
            }
        }
        return t;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String t = strs[0];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    t = t.substring(0, i);
                    break;
                }
            }
        }
        return t;
    }
}
