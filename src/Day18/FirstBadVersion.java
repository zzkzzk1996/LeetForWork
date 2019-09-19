package Day18;

/**
 * @program: LeetForWork
 * @description: 278. First Bad Version
 * @author: Zekun Zhang
 * @create: 2019-09-18 22:55
 */

public class FirstBadVersion {
    public boolean isBadVersion(int k) {
        return true;
    }

    public int firstBadVersion(int n) {
        int start = 0, end = n;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
