package Day71;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 173. Binary Search Tree Iterator
 * @author: Zekun Zhang
 * @create: 2019-11-25 16:57
 */

public class BinarySearchTreeIterator {
    private TreeNode cur;
    private Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty() || cur != null) {
            return true;
        }
        return false;
    }
}
