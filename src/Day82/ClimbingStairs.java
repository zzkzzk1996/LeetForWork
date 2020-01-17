package Day82;

/**
 * @program: LeetForWork
 * @description: 70. Climbing Stairs
 * @author: Zekun Zhang
 * @create: 2020-01-17 18:54
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int stepOne = 1, stepTwo = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = stepOne + stepTwo;
            stepTwo = stepOne;
            stepOne = res;
        }
        return res;
    }
}
