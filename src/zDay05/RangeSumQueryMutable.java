package zDay05;

/**
 * @program: LeetForWork
 * @description: 307. Range Sum Query - Mutable
 * @author: Zekun Zhang
 * @create: 2020-02-11 20:44
 */

public class RangeSumQueryMutable {

    private int[] tree;
    private int[] nums;

    public RangeSumQueryMutable(int[] nums) {
        tree = new int[nums.length + 1];
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= nums.length; j += (-j) & (j)) {
            tree[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}
