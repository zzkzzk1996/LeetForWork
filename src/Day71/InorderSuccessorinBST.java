package Day71;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 285. Inorder Successor in BST
 * @author: Zekun Zhang
 * @create: 2019-11-25 17:45
 */

public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return root;
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int val = Integer.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (val == p.val) return cur;
            val = cur.val;
            cur = cur.right;
        }
        return null;
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null) return root;
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) return root;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode res = inorderSuccessor(root.left, p);
            return res != null ? res : root;

        }
    }
}
