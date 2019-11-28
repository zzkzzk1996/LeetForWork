package Day72;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 501. Find Mode in Binary Search Tree
 * @author: Zekun Zhang
 * @create: 2019-11-27 18:09
 */

public class FindModeinBinarySearchTree {
    private TreeNode prev = null;
    private int max = 0;
    private int count = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);

        if (prev != null) {
            if (prev.val != root.val) {
                count = 1;
            } else {
                count++;
            }
        }
        if (count > max){
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root;
        helper(root.right, list);
    }
}
