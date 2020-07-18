package Day42;

import java.util.HashSet;

/**
 * @program: LeetForWork
 * @description: 266. Palindrome Permutation
 * @author: Zekun Zhang
 * @create: 2019-10-12 11:25
 */

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int[] count = new int[256];
        for (Character c : s.toCharArray()) {
            count[c]++;
        }
        boolean check = true;
        for (Integer num : count) {
            if (num % 2 == 1) {
                if (!check) return check;
                check = false;
            }
        }
        return true;
    }
    public boolean canPermutePalindrome1(String s) {
        HashSet<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}
