package Day16;

/**
 * @program: LeetForWork
 * @description: 243. Shortest Word Distance
 * @author: Zekun Zhang
 * @create: 2019-09-16 22:28
 */

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) return 0;
        int res = Integer.MAX_VALUE, pre1 = -1, pre2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (pre2 != -1) {
                    res = Math.min(res, (i - pre2));
                }
                pre1 = i;
            } else if (words[i].equals(word2)) {
                if (pre1 != -1) {
                    res = Math.min(res, (i - pre1));
                }
                pre2 = i;
            }
        }
        return res;
    }
}
