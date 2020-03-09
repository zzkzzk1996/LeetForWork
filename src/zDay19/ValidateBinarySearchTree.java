package zDay19;

/**
 * @program: LeetForWork
 * @description: 98. Validate Binary Search Tree
 * @author: Zekun Zhang
 * @create: 2020-03-07 18:27
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
        return left && right;
    }
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
