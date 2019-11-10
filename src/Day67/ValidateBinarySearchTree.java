package Day67;

/**
 * @program: LeetForWork
 * @description: 98. Validate Binary Search Tree
 * @author: Zekun Zhang
 * @create: 2019-11-09 22:15
 */

//TODO why the first method didn't work???

public class ValidateBinarySearchTree {
//    public static boolean isValidBST(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) return true;
//        if (root.left != null && root.right != null) {
//            if (root.left.val > root.val || root.right.val < root.val) return false;
//        }
//        return isValidBST(root.left) && isValidBST(root.right);
//    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && min >= root.val) return false;
        if (max != null && max <= root.val) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
