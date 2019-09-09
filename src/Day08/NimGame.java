package Day08;

/**
 * @program: LeetForWork
 * @description: 292. Nim Game
 * @author: Zekun Zhang
 * @create: 2019-09-08 20:24
 */

public class NimGame {
    public boolean canWinNim(int n) {
        return (n % 4) != 0;
    }
}
