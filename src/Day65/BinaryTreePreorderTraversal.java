package Day65;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 144. Binary Tree Preorder Traversal
 * @author: Zekun Zhang
 * @create: 2019-11-05 12:18
 */

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        helper(res, node.left);
        helper(res, node.right);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            res.add(cur.val);
        }
        return res;
    }
}

