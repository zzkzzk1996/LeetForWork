package tree.segmentTree;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-01-10 14:00
 */

public class SegmentTreeByArray {

    private int[] segmentTree;
    private int length;

    public SegmentTreeByArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.length = nums.length - 1;
        this.segmentTree = new int[4 * nums.length];
        buildTree(nums, 0, nums.length - 1, 0);
    }

    public int buildTree(int[] nums, int start, int end, int index) {
        if (start == end) {
            segmentTree[index] = nums[start];
            return segmentTree[index];
        }

        int mid =  start + (end - start) / 2;
        int left = buildTree(nums, start, mid, index * 2 + 1);
        int right = buildTree(nums, mid + 1, end, index * 2 + 2);
        segmentTree[index] = left + right;
        return segmentTree[index];
    }

    public void update(int i, int val) {
        update(0, length, 0, i, val);
    }

    private void update(int start, int end, int index, int pos, int val) {
        if (start == end) {
            segmentTree[index] = val;
            return;
        }

        int mid = start + (end -  start) / 2;
        if (pos <= mid) {
            update(start, mid, index * 2 + 1, pos, val);
        } else {
            update(mid + 1, end, index * 2 + 2, pos, val);
        }
        segmentTree[index] = segmentTree[index * 2 + 1] + segmentTree[index * 2 + 2];
    }

    public int sumRange(int i, int j) {
        return sumRange(0, length, 0, i, j);
    }

    private int sumRange(int start, int end, int index, int left, int right) {
        //TODO understand this
        if (start >= left && end <= right) {
            return segmentTree[index];
        }
        int mid = start + (end -  start) / 2;
        if (right <= mid) {
            return sumRange(start, mid, index * 2 + 1, left, right);
        } else if (left > mid) {
            return sumRange(mid + 1, end, index * 2 + 2, left, right);
        } else {
            return sumRange(start, mid, index * 2 + 1, left, right) + sumRange(mid + 1, end, index * 2 + 2, left, right);
        }
    }
}
