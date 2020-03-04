package zDay15;

/**
 * @program: LeetForWork
 * @description: 390. Elimination Game
 * @author: Zekun Zhang
 * @create: 2020-03-02 17:59
 */

public class EliminationGame {
    public int lastRemaining(int n) {
        if (n < 1) return 0;
        int remain = n;
        int step = 1;
        boolean left = true;
        int head = 1;
        while (remain > 1) {
            if (left || remain % 2 == 1) head += step;
            step *= 2;
            remain /= 2;
            left = !left;
        }
        return head;
    }
}
