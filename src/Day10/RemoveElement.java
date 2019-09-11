package Day10;

/**
 * @program: LeetForWork
 * @description: 27. Remove Element
 * @author: Zekun Zhang
 * @create: 2019-09-10 20:16
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
