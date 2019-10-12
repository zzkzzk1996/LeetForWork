package Day41;

/**
 * @program: LeetForWork
 * @description: 125. Valid Palindrome
 * @author: Zekun Zhang
 * @create: 2019-10-12 11:05
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
            if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) return false;
        }
        return true;
    }
}
