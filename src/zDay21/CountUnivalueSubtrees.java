package zDay21;

/**
 * @program: LeetForWork
 * @description: 250. Count Univalue Subtrees
 * @author: Zekun Zhang
 * @create: 2020-03-13 15:54
 */

public class CountUnivalueSubtrees {
//    private int res = 0;
//    public int countUnivalSubtrees(TreeNode root) {
//        if (root == null) return res;
//        helper(root);
//        return res;
//    }
//
//    private Integer helper(TreeNode root) {
//        if (root.left == null && root.right == null) {
//            res++;
//            return root.val;
//        }
//
//        if (root.left == null ^ root.right == null) {
//            Integer val = root.left == null ? helper(root.right) : helper(root.left);
//            if (val != null && root.val == val) {
//                res++;
//                return root.val;
//            }
//        } else if (root.left != null && root.right != null) {
//            Integer left = helper(root.left);
//            Integer right = helper(root.right);
//            if (left != null && right != null && root.val == right && root.val == left) {
//                res++;
//                return root.val;
//            }
//        }
//        return null;
//    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return res;
        helper(root);
        return res;
    }

    private boolean helper(TreeNode root) {
        if (root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if (root.left != null && root.left.val != root.val) return false;
            if (root.right != null && root.right.val != root.val) return false;
            res++;
            return true;
        }
        return false;
    }
}
