package zDay11;

/**
 * @program: LeetForWork
 * @description: 41. First Missing Positive
 * @author: Zekun Zhang
 * @create: 2020-02-21 16:07
 */

public class FirstMissingPositive {
    public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int[] arr = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] <= nums.length && nums[i - 1] > 0) {
                arr[nums[i - 1]] = 1;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) return i;
        }
        return nums.length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
