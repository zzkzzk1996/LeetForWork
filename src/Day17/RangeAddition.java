package Day17;

/**
 * @program: LeetForWork
 * @description: 370. Range Addition
 * @author: Zekun Zhang
 * @create: 2019-09-17 18:46
 */

//TODO GOOD: NEW WAY FOR THINKING

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length == 0) return null;
        int[] res = new int[length];
        for (int i = 0; i < updates.length; i++) {
            for (int j = updates[i][0]; j <= updates[i][1]; j++) {
                res[j] += updates[i][2];
            }
        }
        return res;
    }

    public int[] getModifiedArray1(int length, int[][] updates) {
        if (length == 0) return null;
        int[] res = new int[length];
        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] + 1 < length) res[update[1] + 1] -= update[2];
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
