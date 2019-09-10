package Day09;

/**
 * @program: LeetForWork
 * @description: 390. Elimination Game
 * @author: Zekun Zhang
 * @create: 2019-09-09 19:57
 */

public class EliminationGame {
    public int lastRemaining(int n) {
        long count = 1;
        boolean left = true;
        int temp = n;
        int res = 1;
        while (temp > 1) {
            if (left || temp % 2 == 1) {
                res += count;
            }
            temp /= 2;
            count *= 2;
            left = !left;
        }
        return res;
    }
}
