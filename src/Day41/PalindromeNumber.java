package Day41;

/**
 * @program: LeetForWork
 * @description: 9. Palindrome Number
 * @author: Zekun Zhang
 * @create: 2019-10-12 11:02
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int origin = x;
        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return origin == reverse;
    }

    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) == s.charAt(end--)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
