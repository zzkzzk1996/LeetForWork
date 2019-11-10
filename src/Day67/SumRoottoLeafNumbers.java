package Day67;

/**
 * @program: LeetForWork
 * @description: 129. Sum Root to Leaf Numbers
 * @author: Zekun Zhang
 * @create: 2019-11-09 21:54
 */

public class SumRoottoLeafNumbers {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, "");
        return res;
    }

    private void helper(TreeNode root, String cur) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(cur + root.val);
            return;
        }
        helper(root.left, cur + root.val);
        helper(root.right, cur + root.val);
    }

    public int sumNumbers1(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}
