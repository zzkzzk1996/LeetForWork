package zDay11;

/**
 * @program: LeetForWork
 * @description: 65. Valid Number
 * @author: Zekun Zhang
 * @create: 2020-02-21 16:44
 */

public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numberSeen = false;
        boolean numberSeenE = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if (s.charAt(i) == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (Character.isDigit(s.charAt(i))) {
                numberSeen = true;
                numberSeenE = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) return false;
                eSeen = true;
                numberSeenE = false;
            } else return false;
        }
        return numberSeen && numberSeenE;
    }
}
