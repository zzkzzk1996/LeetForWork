package Day65;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 102. Binary Tree Level Order Traversal
 * @author: Zekun Zhang
 * @create: 2019-11-05 13:01
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
