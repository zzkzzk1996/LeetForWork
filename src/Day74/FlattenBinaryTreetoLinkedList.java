package Day74;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 114. Flatten Binary Tree to Linked List
 * @author: Zekun Zhang
 * @create: 2019-12-01 16:06
 */

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            cur.left = null;
            cur.right = null;
            if (cur != root) {
                root.right = cur;
                root = root.right;
            }
        }
    }

    TreeNode pre = null;
    public void flatten1(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
