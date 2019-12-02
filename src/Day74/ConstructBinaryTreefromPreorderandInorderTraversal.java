package Day74;

/**
 * @program: LeetForWork
 * @description: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * @author: Zekun Zhang
 * @create: 2019-12-01 19:19
 */

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (inStart > inEnd || preStart > preorder.length - 1) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        root.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }
}
