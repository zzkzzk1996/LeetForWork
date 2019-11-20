package Day69;

/**
 * @program: LeetForWork
 * @description: 124. Binary Tree Maximum Path Sum
 * @author: Zekun Zhang
 * @create: 2019-11-19 11:46
 */

//TODO


public class BinaryTreeMaximumPathSum {
    private int res;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
