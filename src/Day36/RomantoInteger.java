package Day36;

import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 13. Roman to Integer
 * @author: Zekun Zhang
 * @create: 2019-10-06 21:51
 */

public class RomantoInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int valueNow = getNumber(c);
            if (i + 1 < s.length()) {
                int valueNext = getNumber(s.charAt(i + 1));
                if (valueNext > valueNow) {
                    valueNow = valueNext - valueNow;
                    i++;
                }
            }
            res += valueNow;
        }
        return res;
    }

    private int getNumber(char c) {
        int res = 0;
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return res;
    }
}
