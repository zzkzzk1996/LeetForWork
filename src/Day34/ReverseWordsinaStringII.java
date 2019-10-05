package Day34;

/**
 * @program: LeetForWork
 * @description: 186. Reverse Words in a String II
 * @author: Zekun Zhang
 * @create: 2019-10-04 22:59
 */

public class ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        if (s == null) return;
        reverse(s, 0, s.length - 1);
        int r = 0;
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            r++;
        }

    }
    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
