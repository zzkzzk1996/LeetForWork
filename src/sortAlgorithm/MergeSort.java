package sortAlgorithm;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-14 23:18
 */

public class MergeSort {
    private static int[] mergeSort(int low, int high, int[] nums) {
        int mid = (high - low) / 2 + low;
        if (low < high) {
            mergeSort(low, mid, nums);
            mergeSort(mid + 1, high, nums);
            merge(low, mid, high, nums);
        }
        return nums;
    }
    private static void merge(int low, int mid, int high, int[]nums) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i];
            } else {
                temp[k++] = nums[j];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums[x + low] = temp[x];
        }
    }
}
