package Day66;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 257. Binary Tree Paths
 * @author: Zekun Zhang
 * @create: 2019-11-06 16:29
 */

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, "");
        return res;
    }

    private void helper(List<String> res, TreeNode root, String cur) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            cur = cur + root.val;
            res.add(cur);
            return;
        } else {
            cur = cur + root.val + "->";
        }
        helper(res, root.left, cur);
        helper(res, root.right, cur);
    }
}
