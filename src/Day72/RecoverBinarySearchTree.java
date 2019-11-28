package Day72;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 99. Recover Binary Search Tree
 * @author: Zekun Zhang
 * @create: 2019-11-27 17:58
 */

public class RecoverBinarySearchTree {
    /**
     * My first try
     */
    private int count = 0;
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] res = check(list);
        inorder(root, res);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private void inorder(TreeNode root, int[] res) {
        if (root == null) return;
        inorder(root.left, res);
        root.val = res[count++];
        inorder(root.right, res);
    }

    private int[] check(List<Integer> list) {
        int x = -1;
        int y = -1;
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
            if (i > 0 && res[i] < res[i - 1]) {
                if (x == -1) x = i - 1;
                y = i;
            }
        }
        int temp = res[x];
        res[x] = res[y];
        res[y] = temp;
        return res;
    }

    /**
     *
     */

    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree1(TreeNode root) {
        if (root == null) return;
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        helper(root.right);
    }

}
