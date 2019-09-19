package Day18;

/**
 * @program: LeetForWork
 * @description: 35. Search Insert Position
 * @author: Zekun Zhang
 * @create: 2019-09-18 23:06
 */

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
