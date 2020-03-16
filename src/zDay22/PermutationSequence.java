package zDay22;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 60. Permutation Sequence
 * @author: Zekun Zhang
 * @create: 2020-03-15 14:28
 */

public class PermutationSequence {
    // Naive
//    String res = "";
//    int count = 0;
//    boolean end = false;
//    public String getPermutation(int n, int k) {
//        helper("", n, k);
//        return res;
//    }
//
//    private void helper(String s, int n, int k) {
//        if (s.length() == n) {
//            count++;
//            if (count == k) {
//                res = s;
//                end = true;
//            }
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (end) break;
//            if (s.contains(String.valueOf(i))) continue;
//            helper(s + String.valueOf(i), n, k);
//        }
//    }

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k %= fact[i - 1];
            sb.append(list.get(index));
            list.remove(index);
        }
        return sb.toString();
    }
}
