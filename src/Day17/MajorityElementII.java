package Day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 229. Majority Element II
 * @author: Zekun Zhang
 * @create: 2019-09-17 17:52
 */

//TODO AGAIN

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int count1 = 0, count2 = 0, number1 = 0, number2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(number1);
        if (count2 > nums.length / 3) res.add(number2);
        return res;
    }
}
