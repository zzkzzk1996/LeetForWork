package Day68;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 103. Binary Tree Zigzag Level Order Traversal
 * @author: Zekun Zhang
 * @create: 2019-11-10 12:13
 */

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean check = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (check) {
                    list.add(0, cur.val);
                } else {
                    list.add(cur.val);
                }
            }
            check = !check;
            res.add(list);
        }
        return res;
    }
}
