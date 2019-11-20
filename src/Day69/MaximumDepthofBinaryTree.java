package Day69;

/**
 * @program: LeetForWork
 * @description: 104. Maximum Depth of Binary Tree
 * @author: Zekun Zhang
 * @create: 2019-11-19 11:35
 */

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
