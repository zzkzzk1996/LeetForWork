package zDay06;

/**
 * @program: LeetForWork
 * @description: 134. Gas Station
 * @author: Zekun Zhang
 * @create: 2020-02-12 16:47
 */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) return -1;
        int total = 0, cur = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
