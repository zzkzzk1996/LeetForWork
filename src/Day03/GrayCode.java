package Day03;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 89. Gray Code
 * @author: Zekun Zhang
 * @create: 2019-09-03 13:59
 */

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            res.add((i ^ (i >> 1)));
        }
        return res;
    }
}
