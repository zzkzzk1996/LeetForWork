package Day17;

/**
 * @program: LeetForWork
 * @description: 274. H-Index
 * @author: Zekun Zhang
 * @create: 2019-09-17 16:36
 */

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int[] hIndex = new int[citations.length + 1];
        for (int c : citations) {
            hIndex[Math.min(c, citations.length)]++;
        }
        int count = 0;
        for (int i = hIndex.length - 1; i >= 0; i--) {
            count += hIndex[i];
            if (count >= i) return i;
        }
        return 0;
    }
}
