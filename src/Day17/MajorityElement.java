package Day17;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: LeetForWork
 * @description: 169. Majority Element
 * @author: Zekun Zhang
 * @create: 2019-09-17 17:54
 */

//TODO AGAIN MOORE VOTING ALGORITHM

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) pre = nums[i];
            count += (pre == nums[i]) ? 1 : -1;
        }
        return pre;
    }

    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) return num;
        }
        return 0;
    }
}
