package zDay20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @program: LeetForWork
 * @description: 611. Valid Triangle Number
 * @author: Zekun Zhang
 * @create: 2020-03-10 18:30
 */

public class ValidTriangleNumber {
    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] > 0) {
                 set.add(nums[i]);
                 map.put(nums[i], i);
             }
         }
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            while (i < nums.length && nums[i] == 0) i++;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int max = nums[i] + nums[j];
                if (map.containsKey(set.floor(max - 1))) {
                    int pos = map.get(set.floor(max - 1));
                    res += pos - j;
                }
            }
        }
        return res;
    }
}
