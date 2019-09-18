package Day17;

/**
 * @program: LeetForWork
 * @description: 277. Find the Celebrity
 * @author: Zekun Zhang
 * @create: 2019-09-17 18:05
 */

public class FindtheCelebrity {
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int candidate = -1;
        for (int i = 0; i < n; i++) {
            if (candidate == -1) {
                candidate = i;
                continue;
            }
            if (knows(i, candidate)) {
                if (knows(candidate, i)) {
                    candidate = -1;
                }
            } else {
                candidate = i;
            }
        }
        if (candidate != -1) {
            for (int i = 0; i < n; i++) {
                if (i != candidate && (!knows(i, candidate) || (knows(candidate, i)))) {
                    candidate = -1;
                    break;
                }
            }
        }
        return candidate;
    }

    public int findCelebrity1(int n) {
        if (n < 2) return -1;
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || (knows(candidate, i)))) {
                candidate = -1;
                break;
            }
        }
        return candidate;
    }
    private boolean knows(int a, int b) {
        return false;
    }
}
