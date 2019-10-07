package Day35;

/**
 * @program: LeetForWork
 * @description: 358. Rearrange String k Distance Apart
 * @author: Zekun Zhang
 * @create: 2019-10-05 23:29
 */

//TODO AGAIN

public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        int[] count = new int[26];
        int[] valid = new int[26];
        for (Character c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            int nextLetter = findNext(count, valid, i);
            if (nextLetter == -1) return "";
            res.append((char)('a' + nextLetter));
            count[nextLetter]--;
            valid[nextLetter] = i + k;
        }
        return res.toString();
    }
    private int findNext(int[] count, int[] valid, int index) {
        int max = 0, res = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                res = i;
                max = count[i];
            }
        }
        return res;
    }
}
