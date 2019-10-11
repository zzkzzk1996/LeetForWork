package Day40;

/**
 * @program: LeetForWork
 * @description: 76. Minimum Window Substring
 * @author: Zekun Zhang
 * @create: 2019-10-10 22:17
 */

//TODO IMPORTANT

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        int min = s.length() + 1, minStart = 0, numInT = 0, numNow = 0, numSatisfy = 0;
        int[] countT = new int[256];
        int[] countS = new int[256];
        for (Character c : t.toCharArray()) {
            if (countT[c]++ == 0) numInT++;
        }
        for (int start = 0, end = 0; end < s.length(); end++) {
            Character e = s.charAt(end);
            if (countS[e] == 0 && countT[e] != 0) numNow++;
            if (countS[e] == countT[e] - 1) numSatisfy++;
            countS[e]++;
            while (numNow == numInT && numSatisfy == numInT) {
                Character st = s.charAt(start);
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    minStart = start;
                }
                if (countS[st] == 1 && countT[st] != 0) numNow--;
                if (countS[st] == countT[st] && countT[st] != 0) numSatisfy--;
                countS[st]--;
                start++;
            }
        }
        return min > s.length() ? "" : s.substring(minStart, min + minStart);
    }

    public String minWindow1(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        int min = s.length() + 1, minStart = 0, num = t.length();
        int[] count = new int[256];
        for (Character c : t.toCharArray()) {
            count[c]++;
        }
        for (int start = 0, end = 0; end < s.length(); end++) {
            Character e = s.charAt(end);
            if (count[e]-- > 0) num--;
            while (num == 0) {
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    minStart = start;
                }
                if (++count[s.charAt(start++)] > 0) num++;
            }
        }
        return min > s.length() ? "" : s.substring(minStart, min + minStart);
    }
}
