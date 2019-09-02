package Day01;

/**
 * @program: LeetForWork
 * @description: 389. Find the Difference: XOR
 * @author: Zekun Zhang
 * @create: 2019-09-01 19:04
 */

public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }
}
