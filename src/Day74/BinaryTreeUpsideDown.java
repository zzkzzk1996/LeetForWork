package Day74;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 156. Binary Tree Upside Down
 * @author: Zekun Zhang
 * @create: 2019-12-01 15:20
 */

public class BinaryTreeUpsideDown {
    TreeNode pre = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode res;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        res = stack.peek();
        while (!stack.isEmpty()) {
            cur = stack.pop();
            TreeNode next = null;
            if (stack.size() != 0) {
                next = stack.peek();
            }
            cur.right = next;
            if (next != null) {
                cur.left = next.right;
                next.left = null;
                next.right = null;
            }

        }
        return res;
    }

    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }
}
