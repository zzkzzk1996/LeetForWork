package Day17;

/**
 * @program: LeetForWork
 * @description: 280. Wiggle Sort
 * @author: Zekun Zhang
 * @create: 2019-09-17 15:35
 */

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            if (((nums[i] > nums[i - 1]) && (i % 2 == 0)) || ((nums[i] < nums[i - 1]) && (i % 2 == 1))) {
                swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
