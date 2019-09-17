package Day16;

/**
 * @program: LeetForWork
 * @description: 245. Shortest Word Distance III
 * @author: Zekun Zhang
 * @create: 2019-09-16 23:36
 */

public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) return 0;
        int res = Integer.MAX_VALUE, pre1 = -1, pre2 = -1;
        boolean checker = true;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) && checker) {
                if (pre2 != -1) {
                    res = Math.min(res, (i - pre2));
                }
                pre1 = i;
                if (word1.equals(word2)) {
                    checker = false;
                }
            } else if (words[i].equals(word2)) {
                if (pre1 != -1) {
                    res = Math.min(res, (i - pre1));
                }
                pre2 = i;
                if (word1.equals(word2)) {
                    checker = true;
                }
            }
        }
        return res;
    }
}
