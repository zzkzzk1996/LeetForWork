package Day74;

/**
 * @program: LeetForWork
 * @description: 106. Construct Binary Tree from Inorder and Postorder Traversal
 * @author: Zekun Zhang
 * @create: 2019-12-01 20:06
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int inStart, int inEnd) {
        if (start < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[start]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = helper(inorder, postorder, start - inEnd + index - 1, inStart, index - 1);
        root.right = helper(inorder, postorder, start - 1, index + 1, inEnd);
        return root;
    }
}
