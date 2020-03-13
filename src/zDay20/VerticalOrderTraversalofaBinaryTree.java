package zDay20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 987. Vertical Order Traversal of a Binary Tree
 * @author: Zekun Zhang
 * @create: 2020-03-10 18:30
 */

public class VerticalOrderTraversalofaBinaryTree {
    private int max = 0;
    private int min = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0);
        List<List<MyNode>> temp = new ArrayList<>();
        for (int i = min; i < max + 1; i++) {
            res.add(new ArrayList<>());
            temp.add(new ArrayList<>());
        }
        dfs(temp, root, 0, 0);
        for (int i = 0; i < temp.size(); i++) {
            Collections.sort(temp.get(i), new Comparator<MyNode>() {
                @Override
                public int compare(MyNode n1, MyNode n2) {
                    if (n1.level == n2.level) {
                        return n1.val - n2.val;
                    } else {
                        return n1.level - n2.level;
                    }
                }
            });
            for (MyNode node : temp.get(i)) {
                res.get(i).add(node.val);
            }
        }
        return res;
    }

    class MyNode {
        int pos;
        int level;
        int val;
        public MyNode(int pos, int level, int val) {
            this.pos = pos;
            this.level = level;
            this.val = val;
        }
    }
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private void helper(TreeNode node, int index) {
        if (node == null) return;
        max = Math.max(max, index);
        min = Math.min(min, index);
        helper(node.left, index - 1);
        helper(node.right, index + 1);
    }

    private void dfs(List<List<MyNode>> res, TreeNode node, int index, int level) {
        if (node == null) return;
        res.get(index - min).add(new MyNode(index, level, node.val));
        dfs(res, node.left, index - 1, level + 1);
        dfs(res, node.right, index + 1, level + 1);
    }
}
