package Day14;

/**
 * @program: LeetForWork
 * @description: 283. Move Zeroes
 * @author: Zekun Zhang
 * @create: 2019-09-15 00:08
 */

//TODO IMPORTANT

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(i, j++, nums);
            }
        }
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void moveZeroes1(int[] nums) {
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
