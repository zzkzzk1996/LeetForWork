package Day66;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 113. Path Sum II
 * @author: Zekun Zhang
 * @create: 2019-11-06 16:37
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, new ArrayList<>(), sum, root);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int sum, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(res, list, sum - root.val, root.left);
        helper(res, list, sum - root.val, root.right);
        list.remove(list.size() - 1);
    }
}
