package AlgorithmForCourse;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-02-12 14:10
 */

public class Quiz2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[25];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(nums));
        int pivot  = -1;
        pivot = partition(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i < pivot) {
                nums[i] = 0;
            } else nums[i] = 1;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int partition(int[] nums) {
        int pivot = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pivot = i;
                break;
            }
        }
        swap(nums, nums.length - 1, pivot);
        int first = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                first += 1;
            }
        }
        return first + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
