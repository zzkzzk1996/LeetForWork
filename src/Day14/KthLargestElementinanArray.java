package Day14;

import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description: 215. Kth Largest Element in an Array
 * @author: Zekun Zhang
 * @create: 2019-09-15 00:16
 */

//TODO TOP K IMPORTANT

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int pos = 0, left = 0, right = nums.length - 1;
        while (true) {
            pos = partition(left, right, nums);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 < k) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
    }

    private int partition(int left, int right, int[] nums) {
        int l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] < nums[left] && nums[r] > nums[left]) {
                swap(l++, r--, nums);
            }
            if (nums[l] >= nums[left]) l++;
            if (nums[r] <= nums[left]) r--;
        }
        swap(left, r, nums);
        return r;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
