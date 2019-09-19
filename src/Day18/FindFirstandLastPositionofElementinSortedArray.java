package Day18;

/**
 * @program: LeetForWork
 * @description: 34. Find First and Last Position of Element in Sorted Array
 * @author: Zekun Zhang
 * @create: 2019-09-18 23:56
 */

//TODO AGAIN GOOD IDEA

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[]{-1, -1};
        int start = helper(nums, target - 0.5);
        int end = helper(nums, target + 0.5);
        if (start == end) return res;
        res[0] = start;
        res[1] = end - 1;
        return res;
    }
    private int helper(int[] nums, double target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
