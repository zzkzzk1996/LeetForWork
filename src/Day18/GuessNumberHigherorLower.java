package Day18;

/**
 * @program: LeetForWork
 * @description: 374. Guess Number Higher or Lower
 * @author: Zekun Zhang
 * @create: 2019-09-18 23:16
 */

public class GuessNumberHigherorLower {

    public int guess(int k) {
        return k;
    }

    public int guessNumber(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
