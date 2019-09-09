package Day08;

import java.util.HashSet;

/**
 * @program: LeetForWork
 * @description: 202. Happy Number
 * @author: Zekun Zhang
 * @create: 2019-09-08 20:29
 */

public class HappyNumber {
    public boolean isHappy(int n) {
        int sum, re;
        HashSet<Integer> set = new HashSet<>();
        while(set.add(n)) {
            sum = 0;
            while(n > 0) {
                re = n % 10;
                sum += re * re;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }
}
