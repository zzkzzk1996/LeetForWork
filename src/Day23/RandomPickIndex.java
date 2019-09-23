package Day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: LeetForWork
 * @description: 398. Random Pick Index
 * @author: Zekun Zhang
 * @create: 2019-09-23 17:12
 */

public class RandomPickIndex {
    int[] nums;
    Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list.get(rand.nextInt(list.size()));
    }

    public int pick1(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rand.nextInt(++count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
