package Day70;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 366. Find Leaves of Binary Tree
 * @author: Zekun Zhang
 * @create: 2019-11-21 16:07
 */

public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int level = Math.max(left, right) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
