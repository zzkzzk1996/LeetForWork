package Day67;

/**
 * @program: LeetForWork
 * @description: 112. Path Sum
 * @author: Zekun Zhang
 * @create: 2019-11-06 17:29
 */

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
