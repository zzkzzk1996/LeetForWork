package Day15;

/**
 * @program: LeetForWork
 * @description: 334. Increasing Triplet Subsequence
 * @author: Zekun Zhang
 * @create: 2019-09-15 21:19
 */

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if (num <= secMin) secMin = num;
            else if (num > secMin) return true;
        }
        return false;
    }
}
