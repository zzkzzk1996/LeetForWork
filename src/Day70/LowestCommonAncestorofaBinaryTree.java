package Day70;

/**
 * @program: LeetForWork
 * @description: 236. Lowest Common Ancestor of a Binary Tree
 * @author: Zekun Zhang
 * @create: 2019-11-21 18:32
 */

//TODO IMPORTANT

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
