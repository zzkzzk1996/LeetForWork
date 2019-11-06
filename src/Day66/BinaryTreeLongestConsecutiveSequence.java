package Day66;

/**
 * @program: LeetForWork
 * @description: 298. Binary Tree Longest Consecutive Sequence
 * @author: Zekun Zhang
 * @create: 2019-11-06 16:54
 */

public class BinaryTreeLongestConsecutiveSequence {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, null);
        return res;
    }
    private void helper(TreeNode root, int count, TreeNode parent) {
        if (root == null) return;
        count = (parent != null && parent.val == root.val - 1) ? count + 1 : 1;
        res = Math.max(count, res);
        helper(root.left, count, root);
        helper(root.right, count, root);
    }
}
