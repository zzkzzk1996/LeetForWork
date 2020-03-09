package zDay17;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 314. Binary Tree Vertical Order Traversal
 * @author: Zekun Zhang
 * @create: 2020-03-04 19:48
 */

public class BinaryTreeVerticalOrderTraversal {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        helper(root, 0);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < max - min + 1; i++) {
            list.add(new ArrayList<>());
        }

        HashMap<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, -min);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.get(map.get(cur)).add(cur.val);
            if (cur.left != null) {
                map.put(cur.left, map.get(cur) - 1);
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, map.get(cur) + 1);
                queue.add(cur.right);
            }
        }
        return list;
    }

    private void helper(TreeNode node, int index) {
        if (node == null) return;
        max = Math.max(max, index);
        min = Math.min(min, index);
        helper(node.left, index - 1);
        helper(node.right, index + 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
