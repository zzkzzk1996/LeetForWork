package Day19;

/**
 * @program: LeetForWork
 * @description: 275. H-Index II
 * @author: Zekun Zhang
 * @create: 2019-09-19 22:09
 */

public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int left = 0, right = citations.length, n = citations.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (n - mid > citations[mid]) {
                left = mid + 1;
            } else if (n - mid < citations[mid]) {
                right = mid;
            } else {
                return n - mid;
            }
        }
        return n - left;
    }
}
