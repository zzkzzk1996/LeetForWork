package Day74;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 95. Unique Binary Search Trees II
 * @author: Zekun Zhang
 * @create: 2019-12-01 20:20
 */

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) list.add(null);

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = helper(start, i - 1);
            List<TreeNode> rightList = helper(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
