package Day67;

/**
 * @program: LeetForWork
 * @description: 111. Minimum Depth of Binary Tree
 * @author: Zekun Zhang
 * @create: 2019-11-09 22:06
 */

public class MinimumDepthofBinaryTree {
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1);
        return minDepth;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, level);
            return;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
