package Day73;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 314. Binary Tree Vertical Order Traversal
 * @author: Zekun Zhang
 * @create: 2019-12-01 15:16
 */

//TODO IMPORTANT

public class BinaryTreeVerticalOrderTraversal {
    private int min = 0;
    private int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0);
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        index.offer(-min);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int idx = index.poll();
            res.get(idx).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                index.offer(idx - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                index.offer(idx + 1);
            }
        }
        return res;
    }

    private void helper(TreeNode root, int pos) {
        if (root == null) return;
        min = Math.min(min, pos);
        max = Math.max(max, pos);
        helper(root.left, pos - 1);
        helper(root.right, pos + 1);
    }
}
