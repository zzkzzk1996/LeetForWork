package sortAlgorithm;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-14 23:30
 */

public class QuickSort {
    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }
    private static int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[pivotIndex];
        int l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(l++, r--, nums);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }
        swap(pivotIndex, r, nums);
        return r;
    }

    private static int[] swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
