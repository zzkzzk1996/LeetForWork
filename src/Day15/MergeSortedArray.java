package Day15;

/**
 * @program: LeetForWork
 * @description: 88. Merge Sorted Array
 * @author: Zekun Zhang
 * @create: 2019-09-15 21:58
 */

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }
}
