package Day17;

/**
 * @program: LeetForWork
 * @description: 189. Rotate Array
 * @author: Zekun Zhang
 * @create: 2019-09-17 12:04
 */

public class RotateArray {
    /**
     * time: O(N)
     * space: O(K)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        int[] temp = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[i - nums.length + k] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        if (temp.length != 0) {
            System.arraycopy(temp, 0, nums, 0, k);
        }
    }

    /**
     * time: O(N * K)
     * space: O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = pre;
        }
    }

    /**
     * time: O(N)
     * space: O(1)
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
