package Day19;

/**
 * @program: LeetForWork
 * @description: 153. Find Minimum in Rotated Sorted Array
 * @author: Zekun Zhang
 * @create: 2019-09-19 23:55
 */

//TODO AGAIN

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[left] <= nums[right]) return nums[left];
            if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public int findMin1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else right = mid;
        }
        return nums[left - 1];
    }
}
