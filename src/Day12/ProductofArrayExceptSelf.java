package Day12;

/**
 * @program: LeetForWork
 * @description: 238. Product of Array Except Self
 * @author: Zekun Zhang
 * @create: 2019-09-12 17:51
 */

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int rightPro = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= rightPro;
            rightPro *= nums[i];
        }
        return res;
    }
}
