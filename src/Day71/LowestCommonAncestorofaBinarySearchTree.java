package Day71;

/**
 * @program: LeetForWork
 * @description: 235. Lowest Common Ancestor of a Binary Search Tree
 * @author: Zekun Zhang
 * @create: 2019-11-25 16:39
 */

public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
