package Day70;

/**
 * @program: LeetForWork
 * @description: 337. House Robber III
 * @author: Zekun Zhang
 * @create: 2019-11-21 18:13
 */

//TODO

public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    public int rob1(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] temp = new int[2];
        temp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        temp[1] = root.val + left[0] + right[0];
        return temp;
    }
}
