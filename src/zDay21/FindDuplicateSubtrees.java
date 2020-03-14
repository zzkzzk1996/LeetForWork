package zDay21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 652. Find Duplicate Subtrees
 * @author: Zekun Zhang
 * @create: 2020-03-13 17:16
 */

public class FindDuplicateSubtrees {
    private HashMap<String, Integer> map = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return res;
        helper(root);
        return res;
    }

    private String helper(TreeNode node) {
        if (node == null) return "null";
        String thisNode = String.valueOf(node.val) + "," + helper(node.left) + "," + helper(node.right);
        map.put(thisNode, map.getOrDefault(thisNode, 0) + 1);
        if (map.get(thisNode) == 2) {
            res.add(node);
        }
        return thisNode;
    }

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
}
