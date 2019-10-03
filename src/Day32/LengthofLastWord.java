package Day32;

/**
 * @program: LeetForWork
 * @description: 58. Length of Last Word
 * @author: Zekun Zhang
 * @create: 2019-10-02 23:37
 */

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        String[] temp = s.split("\\s+");
        return temp[temp.length - 1].length();
    }
}
