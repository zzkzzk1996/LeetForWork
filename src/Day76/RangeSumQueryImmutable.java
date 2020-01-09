package Day76;

/**
 * @program: LeetForWork
 * @description: 303. Range Sum Query - Immutable
 * @author: Zekun Zhang
 * @create: 2020-01-09 20:58
 */

public class RangeSumQueryImmutable {
    private int[] sum;
    public RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i <  nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
