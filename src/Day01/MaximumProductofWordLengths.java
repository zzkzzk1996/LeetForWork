package Day01;

/**
 * @program: LeetForWork
 * @description: 318. Maximum Product of Word Lengths: BitMap
 * @author: Zekun Zhang
 * @create: 2019-09-01 20:01
 */

public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] bytes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bytes[i] = val;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
