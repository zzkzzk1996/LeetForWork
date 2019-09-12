package Day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 228. Summary Ranges
 * @author: Zekun Zhang
 * @create: 2019-09-11 21:34
 */

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        String temp = "";
        for (int i = 0; i < nums.length; i++) {
            if (temp.length() == 0) {
                temp = Integer.toString(nums[i]);
                if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {
                    res.add(temp);
                    temp = "";
                }
            } else {
                if (i == nums.length - 1 || nums[i] != nums[i + 1] - 1) {
                    temp += "->" + Integer.toString(nums[i]);
                    res.add(temp);
                    temp = "";
                }
            }
        }
        return res;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int num;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            if (num != nums[i]) {
                res.add(num + "->" + nums[i]);
            } else {
                res.add(num + "");
            }
        }
        return res;
    }

}
