package Day72;

/**
 * @program: LeetForWork
 * @description: 108. Convert Sorted Array to Binary Search Tree
 * @author: Zekun Zhang
 * @create: 2019-11-27 19:38
 */

//TODO IMPORTANT

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (right < left) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
