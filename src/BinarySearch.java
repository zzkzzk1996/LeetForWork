import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-18 20:55
 */

public class BinarySearch {
    /**
     * Recursive
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (high <= low) return -1;
        int mid = (high - low) / 2 + low;
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, low, target);
        } else return mid;
    }

    /**
     * Iterative1
     * right < target < left
     * right + 1 = left
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;  //[left, right]
        while (left <= right) { //left > right
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1; //[mid + 1, right]
            } else if (nums[mid] > target) {
                right = mid - 1;    //[left, mid - 1]
            } else return mid;
        }
        return -1;
    }

    /**
     * Iterative2
     * right = left > target
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length; //[left, right)
        while (left < right) {  //left = right
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1; //[mid + 1, right)
            } else if (nums[mid] > target) {
                right = mid;    //[left, mid)
            } else return mid;
        }
        return -1;
    }

    /**
     * Iterative3
     * left < target < right
     * left + 1 = right
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        int left = 0, right = nums.length - 1; //[left, right]
        while (left + 1 < right) {  //left + 1 = right
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid; //[mid, right]
            } else if (nums[mid] > target) {
                right = mid;    //[left, mid]
            } else return mid;
        }
        if (target == nums[left]) {
            return left;
        } else if (target == nums[right]) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] k = new int[0];
        Arrays.binarySearch(k, 1);
    }
}
