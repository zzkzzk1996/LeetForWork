package zDay18;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 662. Maximum Width of Binary Tree
 * @author: Zekun Zhang
 * @create: 2020-03-05 11:03
 */

public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size(), left = 0;
            boolean first = true;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.node == null) continue;
                if (first) left = cur.pos; first = false;
                res = Math.max(cur.pos - left + 1, res);
                queue.offer(new Node(cur.node.left, cur.depth + 1, cur.pos * 2));
                queue.offer(new Node(cur.node.right, cur.depth + 1, cur.pos * 2 + 1));
            }
        }
        return res;
    }
    class Node {
        TreeNode node;
        int depth, pos;
        Node(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }
    class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
