package Day19;

/**
 * @program: LeetForWork
 * @description: 154. Find Minimum in Rotated Sorted Array II
 * @author: Zekun Zhang
 * @create: 2019-09-19 23:59
 */

//TODO AGAIN

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
