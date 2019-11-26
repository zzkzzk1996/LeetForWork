package Day71;

/**
 * @program: LeetForWork
 * @description: 270. Closest Binary Search Tree Value
 * @author: Zekun Zhang
 * @create: 2019-11-25 16:54
 */

public class ClosestBinarySearchTreeValue {
    private double absValue = Double.MAX_VALUE;
    private int preValue;
    public int closestValue(TreeNode root, double target) {
        if (root == null) return preValue;
        if (Math.abs(root.val - target) < absValue) {
            absValue = Math.abs(root.val - target);
            preValue = root.val;
        }
        if (root.val > target) {
            return closestValue(root.left, target);
        } else if (root.val < target) {
            return closestValue(root.right, target);
        } else {
            return root.val;
        }
    }

    public int closestValue1(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }

            root = root.val > target ? root.left : root.right;
        }
        return res;
    }

}
