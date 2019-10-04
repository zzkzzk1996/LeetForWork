package Day33;

/**
 * @program: LeetForWork
 * @description: 161. One Edit Distance
 * @author: Zekun Zhang
 * @create: 2019-10-03 10:09
 */

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() == 0 && t.length() == 0) return false;
        if (s.length() == 0 || t.length() == 0) return true;
        boolean check = true;
        int i = 0, j = 0;
        while (i < s.length() || j < t.length()) {
            char sc = i == s.length() ? s.charAt(i - 1) : s.charAt(i);
            char tc = j == t.length() ? t.charAt(j - 1) : t.charAt(j);
            if (sc != tc) {
                if (check) {
                    check = false;
                    if (i + 1 < s.length() && s.charAt(i + 1) == tc) {
                        j--;
                    } else if (j + 1 < t.length() && sc == t.charAt(j + 1)) {
                        i--;
                    }
                } else {
                    return false;
                }
            }
            i++;
            j++;
        }
        return t.length() == s.length() ? !check : true;
    }

    public boolean isOneEditDistance1(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return t.substring(i + 1).equals(s.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
