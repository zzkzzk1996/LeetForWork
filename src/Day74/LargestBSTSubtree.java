package Day74;

/**
 * @program: LeetForWork
 * @description: 333. Largest BST Subtree
 * @author: Zekun Zhang
 * @create: 2019-12-01 16:55
 */

public class LargestBSTSubtree {
    private int res = 1;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    private SearchNode helper(TreeNode node) {
        if (node == null) return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        SearchNode left = helper(node.left);
        SearchNode right = helper(node.right);

        if (left.size == -1 || right.size == -1 || node.val >= right.lower || node.val <= left.upper) {
            return new SearchNode(-1, 0, 0);
        }

        int size = left.size + right.size + 1;
        res = Math.max(res, size);
        return new SearchNode(size, Math.min(left.lower, node.val), Math.max(right.upper, node.val));
    }

    class SearchNode {
        int size;
        int lower;
        int upper;

        public SearchNode(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}
