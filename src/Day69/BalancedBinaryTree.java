package Day69;

/**
 * @program: LeetForWork
 * @description: 110. Balanced Binary Tree
 * @author: Zekun Zhang
 * @create: 2019-11-19 11:38
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs((helper(root.left) - helper(root.right))) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}
