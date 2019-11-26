package Day71;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 230. Kth Smallest Element in a BST
 * @author: Zekun Zhang
 * @create: 2019-11-25 17:28
 */

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0) return cur.val;
            cur = cur.right;
        }
    }

    private int count;
    private int res;
    public int kthSmallest1(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) res = root.val;
        helper(root.right);
    }
}
