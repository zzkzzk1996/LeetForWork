package zDay23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 103. Binary Tree Zigzag Level Order Traversal
 * @author: Zekun Zhang
 * @create: 2020-03-15 21:20
 */

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean left = true;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                if (left) {
//                    if (cur.left != null) queue.add(size - i - 1, cur.left);
//                    if (cur.right != null) queue.add(size - i - 1, cur.right);
//                } else {
//                    if (cur.right != null) queue.add(size - i - 1, cur.right);
//                    if (cur.left != null) queue.add(size - i - 1, cur.left);
//                }
//                list.add(cur.val);
//            }
//            res.add(list);
//            left = !left;
//        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (left) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
            }
            res.add(list);
            left = !left;
        }
        return res;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
