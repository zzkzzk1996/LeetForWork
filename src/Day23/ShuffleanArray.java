package Day23;

import java.util.Random;

/**
 * @program: LeetForWork
 * @description: 384. Shuffle an Array
 * @author: Zekun Zhang
 * @create: 2019-09-22 16:37
 */

public class ShuffleanArray {
    int[] nums;
    Random random;


    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            int rand = this.random.nextInt(i + 1);
            swap(clone, i, rand);
        }
        return clone;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
