package zDay17;

/**
 * @program: LeetForWork
 * @description: 387. First Unique Character in a String
 * @author: Zekun Zhang
 * @create: 2020-03-03 21:59
 */

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] dict = new int[26];
        for (Character c : s.toCharArray()) {
            dict[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (dict[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
