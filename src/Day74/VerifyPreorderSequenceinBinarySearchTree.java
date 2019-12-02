package Day74;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 255. Verify Preorder Sequence in Binary Search Tree
 * @author: Zekun Zhang
 * @create: 2019-12-01 16:23
 */

//TODO TOO HARD

public class VerifyPreorderSequenceinBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int val : preorder) {
            if (val < min) return false;
            while (!stack.isEmpty() && val > stack.peek()) {
                min = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}
