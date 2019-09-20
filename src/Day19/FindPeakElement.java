package Day19;

/**
 * @program: LeetForWork
 * @description: 162. Find Peak Element
 * @author: Zekun Zhang
 * @create: 2019-09-19 21:37
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right) return left;
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
