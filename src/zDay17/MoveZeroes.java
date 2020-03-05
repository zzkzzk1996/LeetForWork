package zDay17;

/**
 * @program: LeetForWork
 * @description: 283. Move Zeroes
 * @author: Zekun Zhang
 * @create: 2020-03-04 14:21
 */

public class MoveZeroes {
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = 0;
        while (j < nums.length) {
            while (i < nums.length && nums[i] != 0) i++;
            while (j < nums.length && (j <= i || nums[j] == 0)) j++;
            if (j < nums.length && i < nums.length) swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        while (start < nums.length) {
            nums[start++] = 0;
        }
    }
}
