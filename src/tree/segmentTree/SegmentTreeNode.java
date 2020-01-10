package tree.segmentTree;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-01-09 21:20
 */

public class SegmentTreeNode {

    int start;
    int end;
    SegmentTreeNode left;
    SegmentTreeNode right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.left = null;
        this.right = null;
    }
}
