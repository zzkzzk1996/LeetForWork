package Day34;

/**
 * @program: LeetForWork
 * @description: 344. Reverse String
 * @author: Zekun Zhang
 * @create: 2019-10-04 22:37
 */

public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) return;
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
