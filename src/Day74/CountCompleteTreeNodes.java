package Day74;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 222. Count Complete Tree Nodes
 * @author: Zekun Zhang
 * @create: 2019-12-01 19:04
 */

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res += size;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return res;
    }

    public int countNodes1(TreeNode root) {
        return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
    }

    public int countNodes3(TreeNode root) {
        int left = helper(root, true);
        int right = helper(root, false);

        if (left == right) {
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int helper(TreeNode node, boolean side) {
        if (node == null) return 0;
        return side ? helper(node.left, side) + 1 : helper(node.right, side) + 1;
    }
}
