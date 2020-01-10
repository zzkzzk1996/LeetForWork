package tree.segmentTree;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-01-10 13:20
 */

public class SegmentTreeByTreeNode {

    SegmentTreeNode root;

    public SegmentTreeByTreeNode(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentTreeNode cur = new SegmentTreeNode(start, end);
        if (start == end) {
            cur.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            cur.left = buildTree(nums, start, mid);
            cur.right = buildTree(nums, mid + 1, end);
            cur.sum = (cur.left == null ? 0 : cur.left.sum) + (cur.right == null ? 0 : cur.right.sum);
        }
        return cur;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode cur, int pos, int val) {
        if (cur == null) return;
        if (cur.start == cur.end) {
            cur.sum = val;
            return;
        }
        int mid = cur.start + (cur.end - cur.start) / 2;
        if (pos <= mid) {
            update(cur.left, pos, val);
        } else {
            update(cur.right, pos, val);
        }
        cur.sum = (cur.left == null ? 0 : cur.left.sum) + (cur.right == null ? 0 : cur.right.sum);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode cur, int start, int end) {
        if (start > end || cur == null) return 0;
        if (cur.start == start && cur.end == end) return cur.sum;
        else {
            int mid = cur.start + (cur.end - cur.start) / 2;
            if (end <= mid) {
                return sumRange(cur.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(cur.right, start, end);
            } else {
                return sumRange(cur.left, start, mid) + sumRange(cur.right, mid + 1, end);
            }
        }
    }
}
