package Day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 368. Largest Divisible Subset
 * @author: Zekun Zhang
 * @create: 2019-09-09 16:24
 */

//TODO IMPORTANT DP

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        count[0] = 1;
        Arrays.fill(pre, -1);
        Arrays.fill(count, 1);
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
        }
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return n == 1 ? Arrays.asList(nums[0]) : res;
    }
}
