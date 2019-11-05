package Day65;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 94. Binary Tree Inorder Traversal
 * @author: Zekun Zhang
 * @create: 2019-11-05 12:25
 */

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode node) {
        if (node == null) return;
        helper(res, node.left);
        res.add(node.val);
        helper(res, node.right);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
