package Day34;

/**
 * @program: LeetForWork
 * @description: 151. Reverse Words in a String
 * @author: Zekun Zhang
 * @create: 2019-10-04 23:14
 */

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] words = s.trim().split("\\s+");
        if (words.length == 0) return "";
        StringBuilder res = new StringBuilder("");
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i] + " ");
        }
        return res.toString().trim();
    }
}
