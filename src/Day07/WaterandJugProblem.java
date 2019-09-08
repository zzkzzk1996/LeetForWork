package Day07;

/**
 * @program: LeetForWork
 * @description: 365. Water and Jug Problem: GCD Problem
 * @author: Zekun Zhang
 * @create: 2019-09-07 21:35
 */

public class WaterandJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x + y == z || x == z || y == z) return true;
        return z % gcd(x, y) == 0;
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
