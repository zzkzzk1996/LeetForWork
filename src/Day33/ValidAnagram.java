package Day33;

/**
 * @program: LeetForWork
 * @description: 242. Valid Anagram
 * @author: Zekun Zhang
 * @create: 2019-10-03 11:05
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int n : count) {
            if (n != 0) return false;
        }
        return true;
    }
}
