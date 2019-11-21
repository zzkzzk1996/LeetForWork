package Day70;

/**
 * @program: LeetForWork
 * @description: 250. Count Univalue Subtrees
 * @author: Zekun Zhang
 * @create: 2019-11-21 15:46
 */

public class CountUnivalueSubtrees {
    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private boolean helper(TreeNode root) {
        if (root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if (root.left != null && root.left.val != root.val) return false;
            if (root.right != null && root.right.val != root.val) return false;
            res++;
            return true;
        }
        return false;
    }
}
