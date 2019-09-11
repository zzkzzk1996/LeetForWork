package sortAlgorithm;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-10 15:20
 */

public class BubbleSort {
    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(j, j - 1, nums);
                }

            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int[] swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4, 3, 2, 6, 1};
        bubbleSort(test);
    }
}
