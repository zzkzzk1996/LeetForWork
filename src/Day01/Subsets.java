package Day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 78. Subsets: bit manipulation & backtracking
 * @author: Zekun Zhang
 * @create: 2019-09-01 21:08
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2.0, nums.length); i++) {
            int t = i;
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & 1) == 1) {
                    temp.add(nums[j]);
                }
                i >>= 1;
            }
            res.add(temp);
            i = t;
        }
        return res;
    }
}
