package zDay22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 652. Find Duplicate Subtrees
 * @author: Zekun Zhang
 * @create: 2020-03-14 11:01
 */

public class FindDuplicateSubtrees {
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return new ArrayList<>();
        helper(root);
        return list;
    }
    private String helper(TreeNode root) {
        if (root == null) return "null";
        String cur = String.valueOf(root.val) + "," + helper(root.left) + "," + helper(root.right);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        if (map.get(cur) == 2) list.add(root);
        return cur;
    }
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
