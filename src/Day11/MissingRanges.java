package Day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 163. Missing Ranges
 * @author: Zekun Zhang
 * @create: 2019-09-11 21:40
 */

//TODO CAUTION: STACK OVERFLOW

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || lower > upper) return res;
        long llower = (long)lower;
        long lupper = (long)upper;
        if (nums.length == 0) {
            if (lower == upper) {
                res.add(lower + "");
            } else {
                res.add(lower + "->" + upper);
            }
        } else {
            int num;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    if (nums[i] > llower + 1) {
                        res.add(llower + "->" + (nums[i] - 1));
                    } else if (nums[i] == llower + 1) {
                        res.add(llower + "");
                    }
                }
                while (i < nums.length - 1 && ((nums[i] == nums[i + 1] - 1) || (nums[i] == nums[i + 1])) ) {
                    i++;
                }
                num = nums[i] + 1;
                if (i != nums.length - 1) {
                    if (nums[i + 1] != num + 1) {
                        res.add(num + "->" + (nums[i + 1] - 1));
                    } else {
                        res.add(num + "");
                    }
                } else {
                    if (nums[i] < lupper - 1) {
                        res.add((nums[i] + 1) + "->" + lupper);
                    } else if (nums[i] == lupper - 1) {
                        res.add(lupper + "");
                    }
                }
            }
        }
        return res;
    }

    public List<String> findMissingRanges1(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || lower > upper) return res;
        long llower = (long)lower;
        long lupper = (long)upper;
        for (int num : nums) {
            if (num == llower) {
                llower++;
            } else if (llower < num) {
                if (llower + 1 == num) {
                    res.add(String.valueOf(llower));
                } else {
                    res.add(llower + "->" + (num - 1));
                }
                llower = (long)num + 1;
            }
        }
        if (llower == lupper) {
            res.add(String.valueOf(lupper));
        } else if (llower < lupper) {
            res.add(llower + "->" + lupper);
        }
        return res;
    }
}
