package sortAlgorithm;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-14 10:49
 */

public class InsertSort {
    private static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) {
                    swap(i, j, nums);
                }
            }
        }
    }

    private static void insertBinarySort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i + 1];
            int left = 0;
            int right = i;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] < temp){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            for (int j = i; j > right; j--) {
                nums[j + 1] = nums[j];
            }
            nums[right + 1] = temp;
        }
    }

    private static int[] swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
